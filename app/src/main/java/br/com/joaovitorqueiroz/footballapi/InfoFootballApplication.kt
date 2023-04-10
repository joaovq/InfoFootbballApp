package br.com.joaovitorqueiroz.footballapi

import android.app.Application
import br.com.joaovitorqueiroz.footballapi.domain.di.containers.AppContainer
import br.com.joaovitorqueiroz.footballapi.preferences.UserPreferences
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class InfoFootballApplication : Application() {
    val appContainer: AppContainer by lazy { AppContainer() }
    val prefs by lazy { UserPreferences(applicationContext) }
}
