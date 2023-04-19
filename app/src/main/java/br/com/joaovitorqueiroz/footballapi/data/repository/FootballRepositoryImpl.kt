package br.com.joaovitorqueiroz.footballapi.data.repository

import br.com.joaovitorqueiroz.footballapi.data.remotedatasource.data.RemoteDataSource
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import javax.inject.Inject

interface FootballRepository {
    suspend fun getAllMatch(): MatchList?
    suspend fun getMatch(id: Long): MatchResponse?
}

class FootballRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource, /*TODO add localDatasource*/
) : FootballRepository {
    override suspend fun getAllMatch(): MatchList? {
        return remoteDataSource.getAll()
    }

    override suspend fun getMatch(id: Long): MatchResponse? {
        return remoteDataSource.getById(id)
    }
}
