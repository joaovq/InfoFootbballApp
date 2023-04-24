package br.com.joaovitorqueiroz.footballapi.ui.matches.data.api

import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.CompetitionResponse

data class CompetitionList(
    val count: Int,
    val filters: Filters,
    val competitionResponses: List<CompetitionResponse>
)