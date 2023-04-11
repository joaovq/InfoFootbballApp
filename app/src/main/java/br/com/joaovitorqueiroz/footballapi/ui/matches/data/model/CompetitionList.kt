package br.com.joaovitorqueiroz.footballapi.ui.matches.data.model

import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Competition

data class CompetitionList(
    val count: Int,
    val filters: Filters,
    val competitions: List<Competition>
)