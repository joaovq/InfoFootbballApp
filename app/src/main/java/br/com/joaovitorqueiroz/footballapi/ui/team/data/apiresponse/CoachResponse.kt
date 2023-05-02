package br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse

import java.util.Date

data class CoachResponse(
    val id: Long?,
    val firstName: String?,
    val name: String?,
    val lastName: String?,
    val dateOfBirth: Date?,
    val nationality: String?,
    val contract: ContractPersonResponse,
)
