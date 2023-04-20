package br.com.joaovitorqueiroz.footballapi.data.remotedatasource.data

import br.com.joaovitorqueiroz.footballapi.core.network.api.config.API_KEY_FOOTBALL
import br.com.joaovitorqueiroz.footballapi.data.datasource.FootballDatasource
import br.com.joaovitorqueiroz.footballapi.data.remotedatasource.service.FootballService
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val serviceFootball: FootballService) :
    FootballDatasource {
    override suspend fun getAll(): MatchList? {
        val matches = serviceFootball.getMatches(API_KEY_FOOTBALL)
        return matches.body()
    }

    override suspend fun getById(id: Long): MatchResponse? =
        serviceFootball.getMatch(API_KEY_FOOTBALL, id).body()

    override suspend fun getHeadToHead(id: Long): Head2HeadResponse? =
        serviceFootball.getMatchHead2Head(API_KEY_FOOTBALL, id).body()

}
