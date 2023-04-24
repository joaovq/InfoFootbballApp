package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model

import java.io.Serializable
import java.util.Date

data class Match(
    val id: Long,
    val area: Area,
    val competition: Competition,
    val status: Status?,
    val stage: Stage?,
    val season: Season,
    val score: Score?,
    val group: Group?,
    val matchDay: Int,
    val lastUpdated: Date,
    val homeTeam: HomeTeam,
    val awayTeam: AwayTeam
) : Serializable
