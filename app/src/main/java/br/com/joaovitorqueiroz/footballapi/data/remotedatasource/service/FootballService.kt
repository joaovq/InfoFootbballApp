package br.com.joaovitorqueiroz.footballapi.data.remotedatasource.service

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.CompetitionList
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

private const val FIELD_AUTH_TOKEN = "X-Auth-Token"
interface FootballService {
    @GET("matches/")
    suspend fun getMatches(@Header(FIELD_AUTH_TOKEN) apiToken: String): Response<MatchList>

    @GET("competitionResponses/")
    suspend fun getCompetitions(@Header(FIELD_AUTH_TOKEN) apiToken: String): Response<CompetitionList>

    @GET("matches/{id}")
    suspend fun getMatch(
        @Header(FIELD_AUTH_TOKEN) apiToken: String,
        @Path("id") id: Long,
    ): Response<MatchResponse>

    @GET("matches/{id}/head2head?limit=15")
    suspend fun getMatchHead2Head(
        @Header(FIELD_AUTH_TOKEN) apiToken: String,
        @Path("id") id: Long,
    ): Response<Head2HeadResponse>

    @GET("teams/{id}/")
    suspend fun getTeamById(
        @Header(FIELD_AUTH_TOKEN) apiToken: String,
        @Path("id")
        id: Long,
    ): Response<TeamResponse>
}
