package com.example.dadm_juego1_grupoa.dataBase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PreguntaDao {
    @Insert
    fun insertarPreguntas(preguntas: List<Pregunta>)

    @Query("SELECT * FROM preguntas")
    fun obtenerTodasLasPreguntas(): List<Pregunta>

    @Query("SELECT * FROM preguntas WHERE tipo = :tipo")
    fun obtenerPreguntasPorTipo(tipo: String): List<Pregunta>

    @Query("SELECT * FROM preguntas WHERE tipo = :tipo AND dificultad = :dificultad ORDER BY RANDOM() LIMIT :numPreguntas")
    fun obtenerPreguntasPorDificultad(tipo: String, dificultad : String, numPreguntas: Int): List<Pregunta>

}

