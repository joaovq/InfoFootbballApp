package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

data class ScoreResponse(
    val winner: WinnerResponse?,
    val duration: String, /*TODO search options for enum*/
    val fullTime: FullTimeResponse,
    val halfTime: HalfTimeResponse
)
