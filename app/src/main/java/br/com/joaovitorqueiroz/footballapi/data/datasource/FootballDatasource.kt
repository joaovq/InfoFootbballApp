package br.com.joaovitorqueiroz.footballapi.data.datasource

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse

interface FootballDatasource {
    suspend fun getAll(): MatchList?
    suspend fun getById(id: Long): MatchResponse?
}