package br.com.joaovitorqueiroz.footballapi.data.api

import br.com.joaovitorqueiroz.footballapi.data.remotedatasource.service.FootballService
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.CompetitionList
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse.TeamResponse
import retrofit2.Response

class FakeApiService(
    initialMatchList: MatchList,
    initialHead2HeadsStorage: List<Head2HeadResponse>,
) : FootballService {

    var fakeMatches: MatchList
    var fakeHead2Head: List<Head2HeadResponse>

    init {
        fakeMatches = initialMatchList
        fakeHead2Head = initialHead2HeadsStorage
    }

    override suspend fun getMatches(apiToken: String): Response<MatchList> {
        return Response.success(fakeMatches)
    }

    override suspend fun getCompetitions(apiToken: String): Response<CompetitionList> {
        TODO("Not yet implemented")
    }

    override suspend fun getMatch(apiToken: String, id: Long): Response<MatchResponse> {
        val response = fakeMatches.matches.first { it?.id == id }
        return Response.success(
            response,
        ) /*?: Response.error()*/
    }

    override suspend fun getMatchHead2Head(
        apiToken: String,
        id: Long,
    ): Response<Head2HeadResponse> {
        return Response.success(
            fakeHead2Head.first {
                it.matches?.first { match -> match.id == id }?.id == id
            },
        )
    }

    override suspend fun getTeamById(apiToken: String, id: Long): Response<TeamResponse> {
        TODO("Not yet implemented")
    }
}
