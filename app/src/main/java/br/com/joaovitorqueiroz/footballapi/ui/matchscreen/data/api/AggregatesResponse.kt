package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

data class AggregatesResponse(
    val numberOfMatches: Int?,
    val totalGoals: Int?,
    val homeTeam: HomeTeamResponse?,
    val awayTeam: AwayTeamResponse?,
)
