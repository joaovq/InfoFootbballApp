package br.com.joaovitorqueiroz.footballapi

import android.app.Application
import br.com.joaovitorqueiroz.footballapi.domain.containers.AppContainer
import br.com.joaovitorqueiroz.footballapi.preferences.UserPreferences

class InfoFootballApplication : Application() {
    val appContainer: AppContainer by lazy { AppContainer() }
    val prefs by lazy { UserPreferences(applicationContext) }
}
