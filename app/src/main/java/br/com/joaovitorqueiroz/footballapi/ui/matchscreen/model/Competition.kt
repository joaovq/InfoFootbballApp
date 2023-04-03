package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model

data class Competition(
    val id: Long,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String
)
