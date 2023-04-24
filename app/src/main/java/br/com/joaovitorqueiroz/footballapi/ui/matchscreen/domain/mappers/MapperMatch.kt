package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.mappers

import br.com.joaovitorqueiroz.footballapi.domain.mapper.toAwayTeam
import br.com.joaovitorqueiroz.footballapi.domain.mapper.toHomeTeam
import br.com.joaovitorqueiroz.footballapi.domain.mapper.toMatch
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.Filters
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.ResultSet
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.AggregatesResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Aggregates
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Head2Head

fun Head2HeadResponse.toHead2Head() = Head2Head(
    this.filters ?: Filters(),
    this.resultSet ?: ResultSet(),
    this.aggregates?.toAggregates(),
    this.matches?.map { it.toMatch() } ?: emptyList(),
)

fun AggregatesResponse.toAggregates() =
    Aggregates(
        this.numberOfMatches ?: 0,
        this.totalGoals,
        this.homeTeam?.toHomeTeam(),
        this.awayTeam?.toAwayTeam(),
    )
