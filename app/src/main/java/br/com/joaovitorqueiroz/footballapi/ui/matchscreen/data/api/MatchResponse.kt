package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

import com.google.gson.annotations.SerializedName
import java.util.*

data class MatchResponse(
    val id: Long,
    val area: AreaResponse,
    val competition: CompetitionResponse,
    val status: StatusResponse?,
    val stage: StageResponse?,
    val season: SeasonResponse,
    val score: ScoreResponse,
    val group: GroupResponse,
    @SerializedName("matchday")
    val matchDay: Int,
    @SerializedName("lastUpdated")
    val lastUpdated: Date,
    val homeTeam: HomeTeamResponse,
    val awayTeam: AwayTeamResponse
)
