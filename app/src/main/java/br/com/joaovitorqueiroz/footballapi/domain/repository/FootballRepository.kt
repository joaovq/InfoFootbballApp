package br.com.joaovitorqueiroz.footballapi.domain.repository

import br.com.joaovitorqueiroz.footballapi.domain.remotedatasource.data.RemoteDataSource
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.model.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Match

interface IFootballRepository {
    suspend fun getAllMatch(): MatchList?
    suspend fun getMatch(id: Long): Match?
}

class FootballRepository(val remoteDataSource: RemoteDataSource) : IFootballRepository {
    override suspend fun getAllMatch(): MatchList? {
        return remoteDataSource.getAll()
    }

    override suspend fun getMatch(id: Long): Match? {
        return remoteDataSource.getById(id)
    }

}