package br.com.joaovitorqueiroz.footballapi.domain.mapper

import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.AreaResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.AwayTeamResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.CompetitionResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.FullTimeResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.GroupResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.HalfTimeResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.HomeTeamResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.ScoreResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.SeasonResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.StageResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.StatusResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.WinnerResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Area
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.AwayTeam
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Competition
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.FullTime
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Group
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.HalfTime
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.HomeTeam
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Match
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Score
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Season
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Stage
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Status
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Winner

fun List<MatchResponse?>?.toMapperCompetition() = this?.map { it?.competition }?.toSet()

fun MatchResponse.toMatch(): Match = Match(
    this.id,
    this.area.toArea(),
    this.competition.toCompetition(),
    this.status?.toStatus(),
    this.stage?.toStage(),
    this.season.toSeason(),
    this.score.toScore(),
    this.group.toGroup(),
    this.matchDay,
    this.lastUpdated,
    this.homeTeam.toHomeTeam(),
    this.awayTeam.toAwayTeam(),
)

fun CompetitionResponse.toCompetition() =
    Competition(this.id, this.area?.toArea(), this.name, this.code, this.type, this.emblem)

fun AreaResponse.toArea() = Area(this.id, this.name, this.code, this.flag)

fun HomeTeamResponse.toHomeTeam() = HomeTeam(
    this.id ?: 0,
    this.name ?: "",
    this.shortName ?: "",
    this.tla ?: "",
    this.crest ?: "",
    this.wins ?: 0,
    this.draws ?: 0,
    this.losses ?: 0,
)

fun AwayTeamResponse.toAwayTeam() = AwayTeam(
    this.id ?: 0,
    this.name ?: "",
    this.shortName ?: "",
    this.tla ?: "",
    this.crest ?: "",
    this.wins ?: 0,
    this.draws ?: 0,
    this.losses ?: 0,
)

fun ScoreResponse.toScore() = Score(
    this.winner?.toWinner(),
    this.duration,
    this.fullTime.toFullTime(),
    this.halfTime.toHalfTime(),
)

fun WinnerResponse.toWinner() = when (this) {
    WinnerResponse.HOME -> Winner.HOME
    WinnerResponse.DRAW -> Winner.DRAW
    WinnerResponse.AWAY -> Winner.AWAY
}

fun FullTimeResponse.toFullTime() = FullTime(
    this.home,
    this.away,
)

fun HalfTimeResponse.toHalfTime() = HalfTime(
    this.home,
    this.away,
)

fun StatusResponse.toStatus() = when (this) {
    StatusResponse.SCHEDULED -> Status.SCHEDULED
    StatusResponse.LIVE -> Status.LIVE
    StatusResponse.IN_PLAY -> Status.IN_PLAY
    StatusResponse.PAUSED -> Status.PAUSED
    StatusResponse.TIMED -> Status.TIMED
    StatusResponse.FINISHED -> Status.FINISHED
    StatusResponse.POSTPONED -> Status.POSTPONED
    StatusResponse.SUSPENDED -> Status.SUSPENDED
    StatusResponse.CANCELED -> Status.CANCELED
}

fun StageResponse.toStage() = when (this) {
    StageResponse.FINAL -> Stage.FINAL
    StageResponse.THIRD_PLACE -> Stage.THIRD_PLACE
    StageResponse.SEMI_FINALS -> Stage.SEMI_FINALS
    StageResponse.QUARTER_FINALS -> Stage.QUARTER_FINALS
    StageResponse.LAST_16 -> Stage.LAST_16
    StageResponse.LAST_32 -> Stage.LAST_32
    StageResponse.LAST_64 -> Stage.LAST_64
    StageResponse.ROUND_4 -> Stage.ROUND_4
    StageResponse.ROUND_3 -> Stage.ROUND_3
    StageResponse.ROUND_2 -> Stage.ROUND_2
    StageResponse.ROUND_1 -> Stage.ROUND_1
    StageResponse.GROUP_STAGE -> Stage.GROUP_STAGE
    StageResponse.PRELIMINARY_ROUND -> Stage.PRELIMINARY_ROUND
    StageResponse.QUALIFICATION -> Stage.QUALIFICATION
    StageResponse.QUALIFICATION_ROUND_1 -> Stage.QUALIFICATION_ROUND_1
    StageResponse.QUALIFICATION_ROUND_2 -> Stage.QUALIFICATION_ROUND_2
    StageResponse.QUALIFICATION_ROUND_3 -> Stage.QUALIFICATION_ROUND_3
    StageResponse.PLAYOFF_ROUND_1 -> Stage.PLAYOFF_ROUND_1
    StageResponse.PLAYOFF_ROUND_2 -> Stage.PLAYOFF_ROUND_2
    StageResponse.PLAYOFFS -> Stage.PLAYOFFS
    StageResponse.REGULAR_SEASON -> Stage.REGULAR_SEASON
    StageResponse.CLAUSURA -> Stage.CLAUSURA
    StageResponse.APERTURA -> Stage.APERTURA
    StageResponse.CHAMPIONSHIP -> Stage.CHAMPIONSHIP
    StageResponse.RELEGATION -> Stage.RELEGATION
    StageResponse.RELEGATION_ROUND -> Stage.RELEGATION_ROUND
}

fun SeasonResponse.toSeason() = Season(
    this.id,
    this.startDate,
    this.endDate,
    this.currentlyMatchDay,
    this.winner,
)

fun GroupResponse?.toGroup() = when (this) {
    GroupResponse.GROUP_A -> Group.GROUP_A
    GroupResponse.GROUP_B -> Group.GROUP_B
    GroupResponse.GROUP_C -> Group.GROUP_C
    GroupResponse.GROUP_D -> Group.GROUP_D
    GroupResponse.GROUP_E -> Group.GROUP_E
    GroupResponse.GROUP_F -> Group.GROUP_F
    GroupResponse.GROUP_G -> Group.GROUP_G
    GroupResponse.GROUP_H -> Group.GROUP_H
    GroupResponse.GROUP_I -> Group.GROUP_I
    GroupResponse.GROUP_J -> Group.GROUP_J
    GroupResponse.GROUP_K -> Group.GROUP_K
    GroupResponse.GROUP_L -> Group.GROUP_L
    else -> null
}
