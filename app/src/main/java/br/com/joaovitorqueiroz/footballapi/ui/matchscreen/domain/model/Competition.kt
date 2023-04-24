package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model

import java.io.Serializable

data class Competition(
    val id: Long,
    val area: Area?,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String,
) : Serializable
