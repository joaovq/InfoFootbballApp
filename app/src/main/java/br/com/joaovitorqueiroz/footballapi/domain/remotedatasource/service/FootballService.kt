package br.com.joaovitorqueiroz.footballapi.domain.remotedatasource.service

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.model.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Match
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballService {
    @GET("matches/")
    suspend fun getMatches(@Header("X-Auth-Token") apiToken: String): Response<MatchList>

    @GET("matches/{id}")
    suspend fun getMatch(
        @Header("X-Auth-Token") apiToken: String,
        @Path("id") id: Long,
    ): Response<Match>
}
