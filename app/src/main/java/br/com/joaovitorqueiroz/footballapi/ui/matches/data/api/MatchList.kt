package br.com.joaovitorqueiroz.footballapi.ui.matches.data.api

import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse

data class MatchList(
    val filters: Filters,
    val resultSet: ResultSet,
    val matches: List<MatchResponse?>
)
