package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model

import java.io.Serializable

data class Area(
    val id: Long,
    val name: String,
    val code: String,
    val flag: String,
) : Serializable
