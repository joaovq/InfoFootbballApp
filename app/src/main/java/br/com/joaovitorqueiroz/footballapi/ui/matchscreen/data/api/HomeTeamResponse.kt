package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

data class HomeTeamResponse(
    val id: Long,
    val name: String?,
    val shortName: String?,
    val tla: String?,
    val crest: String?,
    val wins: Int?,
    val draws: Int?,
    val losses: Int?
)
