package br.com.joaovitorqueiroz.footballapi.data.remotedatasource.service

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.CompetitionList
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballService {
    @GET("matches/")
    suspend fun getMatches(@Header("X-Auth-Token") apiToken: String): Response<MatchList>

    @GET("competitions/")
    suspend fun getCompetitions(@Header("X-Auth-Token") apiToken: String): Response<CompetitionList>

    @GET("matches/{id}")
    suspend fun getMatch(
        @Header("X-Auth-Token") apiToken: String,
        @Path("id") id: Long,
    ): Response<MatchResponse>

    @GET("matches/{id}/head2head?limit=15")
    suspend fun getMatchHead2Head(
        @Header("X-Auth-Token") apiToken: String,
        @Path("id") id: Long,
    ): Response<Head2HeadResponse>
}
