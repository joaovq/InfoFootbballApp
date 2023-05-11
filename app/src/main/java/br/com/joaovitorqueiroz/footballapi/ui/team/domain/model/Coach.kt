package br.com.joaovitorqueiroz.footballapi.ui.team.domain.model

import java.util.Date

data class Coach(
    val id: Long,
    val firstName: String,
    val name: String,
    val lastName: String,
    val dateOfBirth: Date,
    val nationality: String,
    val contract: ContractPerson,
)
