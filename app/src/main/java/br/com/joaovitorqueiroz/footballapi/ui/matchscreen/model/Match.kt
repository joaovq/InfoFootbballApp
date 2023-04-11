package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Match(
    val id: Long,
    val area: Area,
    val competition: Competition,
    val status: Status?,
    val stage: Stage?,
    val season: Season,
    val score: Score,
    val group: Group,
    @SerializedName("matchday")
    val matchDay: Int,
    @SerializedName("lastUpdated")
    val lastUpdated: Date,
    val homeTeam: HomeTeam,
    val awayTeam: AwayTeam
)
