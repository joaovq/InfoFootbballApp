package br.com.joaovitorqueiroz.footballapi

import android.app.Application
import br.com.joaovitorqueiroz.footballapi.domain.containers.AppContainer

class InfoFootballApplication : Application() {
    val appContainer: AppContainer by lazy {
        AppContainer()
    }
}
