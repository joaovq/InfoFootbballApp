package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model

import java.io.Serializable

data class Score(
    val winner: Winner?,
    val duration: String,
    val fullTime: FullTime?,
    val halfTime: HalfTime?,
) : Serializable
