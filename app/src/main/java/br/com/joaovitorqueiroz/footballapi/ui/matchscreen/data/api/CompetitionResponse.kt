package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

data class CompetitionResponse(
    val id: Long,
    val area: AreaResponse?,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String,
)
