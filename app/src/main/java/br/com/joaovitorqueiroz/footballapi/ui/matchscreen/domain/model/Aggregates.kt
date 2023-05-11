package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model

import java.io.Serializable

data class Aggregates(
    val numberOfMatches: Int? = 0,
    val totalGoals: Int? = 0,
    val homeTeam: HomeTeam?,
    val awayTeam: AwayTeam?,
) : Serializable
