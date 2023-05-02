package br.com.joaovitorqueiroz.footballapi.data.datasource

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse.TeamResponse

interface FootballDatasource {
    suspend fun getAll(): MatchList?
    suspend fun getById(id: Long): MatchResponse?
    suspend fun getHeadToHead(id: Long): Head2HeadResponse?
    suspend fun getTeam(id: Long): TeamResponse?
}
