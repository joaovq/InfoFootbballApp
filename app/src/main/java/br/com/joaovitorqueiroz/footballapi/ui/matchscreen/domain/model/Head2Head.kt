package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.Filters
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.ResultSet
import java.io.Serializable

data class Head2Head(
    val filters: Filters,
    val resultSet: ResultSet,
    val aggregates: Aggregates?,
    val matches: List<Match?>,
) : Serializable
