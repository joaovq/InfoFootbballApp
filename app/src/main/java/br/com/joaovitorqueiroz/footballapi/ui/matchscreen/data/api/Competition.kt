package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

data class Competition(
    val id: Long,
    val area: Area?,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String
)
