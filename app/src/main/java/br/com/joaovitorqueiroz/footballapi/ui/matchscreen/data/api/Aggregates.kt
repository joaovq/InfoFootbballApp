package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

data class Aggregates(
    val numberOfMatches: Int?,
    val totalGoals: Int?,
    val homeTeam: HomeTeam?,
    val awayTeam: AwayTeam?,
)
