package br.com.joaovitorqueiroz.footballapi.ui.team.domain.model

import java.util.Date

data class Person(
    val id: Long,
    val name: String,
    val position: String,
    val dateOfBirth: Date,
    val nationality: String,
)
