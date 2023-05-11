package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model

import java.io.Serializable

data class HalfTime(
    val home: Int?,
    val away: Int?
) : Serializable
