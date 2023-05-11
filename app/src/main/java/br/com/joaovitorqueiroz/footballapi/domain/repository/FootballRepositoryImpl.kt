package br.com.joaovitorqueiroz.footballapi.domain.repository

import br.com.joaovitorqueiroz.footballapi.data.remotedatasource.data.RemoteDataSource
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse.TeamResponse
import javax.inject.Inject

interface FootballRepository {
    suspend fun getAllMatch(): MatchList?
    suspend fun getMatch(id: Long): MatchResponse?
    suspend fun getHead2Head(id: Long): Head2HeadResponse?
    suspend fun getTeam(id: Long): TeamResponse?
}

class FootballRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    /*TODO add localDatasource*/
) : FootballRepository {
    override suspend fun getAllMatch(): MatchList? {
        return remoteDataSource.getAll()
    }

    override suspend fun getMatch(id: Long): MatchResponse? {
        return remoteDataSource.getById(id)
    }

    override suspend fun getHead2Head(id: Long): Head2HeadResponse? =
        remoteDataSource.getHeadToHead(id)

    override suspend fun getTeam(id: Long): TeamResponse? = remoteDataSource.getTeam(id)
}
