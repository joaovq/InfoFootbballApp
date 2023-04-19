package br.com.joaovitorqueiroz.footballapi.domain.mapper

import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.model.Match

fun List<MatchResponse?>?.toMapperCompetition() = this?.map { it?.competition }?.toSet()

fun MatchResponse.toMatch(): Match = Match(
    this.id,
    this.area,
    this.competition,
    this.status,
    this.stage,
    this.season,
    this.score,
    this.group,
    this.matchDay,
    this.lastUpdated,
    this.homeTeam,
    this.awayTeam
)
