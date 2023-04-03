package br.com.joaovitorqueiroz.footballapi.ui.matches.data.model

import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Match

data class MatchList(
    val filters: Filters,
    val resultSet: ResultSet,
    val matches: List<Match?>
)
