package br.com.joaovitorqueiroz.footballapi

import android.app.Application
import br.com.joaovitorqueiroz.footballapi.preferences.UserPreferences
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class InfoFootballApplication : Application() {

    @Inject
    lateinit var prefs: UserPreferences
}
