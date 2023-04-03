package br.com.joaovitorqueiroz.footballapi.domain.containers

import br.com.joaovitorqueiroz.footballapi.core.network.api.config.RetrofitConfig
import br.com.joaovitorqueiroz.footballapi.core.network.api.factory.UrlFactory
import br.com.joaovitorqueiroz.footballapi.domain.remotedatasource.service.FootballService

class AppContainer {
    private val retrofit = RetrofitConfig.getInstance(UrlFactory.BASE_URL)

    val service: FootballService = retrofit.create(FootballService::class.java)
}
