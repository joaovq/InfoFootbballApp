package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.model.FullTime

data class Score(
    val winner: Winner,
    val duration: String, /*TODO search options for enum*/
    val fullTime: FullTime,
    val halfTime: HalfTime
)
