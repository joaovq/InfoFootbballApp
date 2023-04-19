package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.model

import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Area
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.AwayTeam
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Competition
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Group
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.HomeTeam
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Score
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Season
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Stage
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Status
import java.util.Date

data class Match(
    val id: Long,
    val area: Area,
    val competition: Competition,
    val status: Status?,
    val stage: Stage?,
    val season: Season,
    val score: Score,
    val group: Group?,
    val matchDay: Int,
    val lastUpdated: Date,
    val homeTeam: HomeTeam,
    val awayTeam: AwayTeam
)
