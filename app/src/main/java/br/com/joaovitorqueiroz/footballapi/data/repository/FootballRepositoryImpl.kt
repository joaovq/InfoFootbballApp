package br.com.joaovitorqueiroz.footballapi.data.repository

import br.com.joaovitorqueiroz.footballapi.data.remotedatasource.data.RemoteDataSource
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.model.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Match
import javax.inject.Inject

interface FootballRepository {
    suspend fun getAllMatch(): MatchList?
    suspend fun getMatch(id: Long): Match?
}

class FootballRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource, /*TODO add localDatasource*/
) : FootballRepository {
    override suspend fun getAllMatch(): MatchList? {
        return remoteDataSource.getAll()
    }

    override suspend fun getMatch(id: Long): Match? {
        return remoteDataSource.getById(id)
    }
}
