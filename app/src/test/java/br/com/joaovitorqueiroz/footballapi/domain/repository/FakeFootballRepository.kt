package br.com.joaovitorqueiroz.footballapi.domain.repository

import br.com.joaovitorqueiroz.footballapi.core.network.api.config.API_KEY_FOOTBALL
import br.com.joaovitorqueiroz.footballapi.data.api.FakeApiService
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse.TeamResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FakeFootballRepository(
    private val service: FakeApiService,
    private val testDispatcher: CoroutineDispatcher = Dispatchers.Unconfined,
) : FootballRepository {
    override suspend fun getAllMatch(): MatchList? {
        return try {
            service.getMatches(API_KEY_FOOTBALL).body()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getMatch(id: Long): MatchResponse? =
        withContext(testDispatcher) {
            try {
                service.getMatch(API_KEY_FOOTBALL, id).body()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

    override suspend fun getHead2Head(id: Long): Head2HeadResponse? =
        withContext(testDispatcher) {
            service.getMatchHead2Head(API_KEY_FOOTBALL, id).body()
        }

    override suspend fun getTeam(id: Long): TeamResponse? {
        TODO("Not yet implemented")
    }
}
