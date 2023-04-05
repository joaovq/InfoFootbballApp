package br.com.joaovitorqueiroz.footballapi.data.datasource

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.model.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Match

interface FootballDatasource {
    suspend fun getAll(): MatchList?
    suspend fun getById(id: Long): Match?
}