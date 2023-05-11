package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.Filters
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.ResultSet

data class Head2HeadResponse(
    val filters: Filters?,
    val resultSet: ResultSet?,
    val aggregates: AggregatesResponse?,
    val matches: List<MatchResponse>?
)
