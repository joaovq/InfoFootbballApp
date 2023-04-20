package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.mappers

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.Filters
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.ResultSet
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Aggregates
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.AwayTeam
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.HomeTeam
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Head2Head

fun Head2HeadResponse.toHead2Head() = Head2Head(
    this.filters ?: Filters(),
    this.resultSet ?: ResultSet(),
    this.aggregates ?: Aggregates(
        0,
        0,
        HomeTeam(0, "", "", "", "", 0, 0, 0),
        AwayTeam(0, "", "", "", "", 0, 0, 0),
    ),
    this.matches ?: emptyList(),
)
