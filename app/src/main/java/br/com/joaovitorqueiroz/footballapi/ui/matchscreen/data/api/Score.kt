package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

data class Score(
    val winner: Winner?,
    val duration: String, /*TODO search options for enum*/
    val fullTime: FullTime,
    val halfTime: HalfTime
)
