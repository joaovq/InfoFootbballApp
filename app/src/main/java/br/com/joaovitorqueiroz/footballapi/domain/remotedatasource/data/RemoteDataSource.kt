package br.com.joaovitorqueiroz.footballapi.domain.remotedatasource.data

import br.com.joaovitorqueiroz.footballapi.core.network.api.config.API_KEY_FOOTBALL
import br.com.joaovitorqueiroz.footballapi.domain.remotedatasource.service.FootballService
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.model.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Match

interface ControllableServiceFootball {
    suspend fun getAll(): MatchList?
    suspend fun getById(id: Long): Match?
}

class RemoteDataSource(private val serviceFootball: FootballService) : ControllableServiceFootball {
    override suspend fun getAll(): MatchList? {
        val matches = serviceFootball.getMatches(API_KEY_FOOTBALL)
        return matches.body()
    }

    override suspend fun getById(id: Long): Match? =
        serviceFootball.getMatch(API_KEY_FOOTBALL, id).body()
}
