package br.com.joaovitorqueiroz.footballapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import br.com.joaovitorqueiroz.footballapi.data.preferences.UserPreferences
import br.com.joaovitorqueiroz.footballapi.databinding.ActivityMainBinding
import br.com.joaovitorqueiroz.footballapi.util.extension.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import timber.log.Timber.Forest.plant
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)

    @Inject
    lateinit var prefs: UserPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (BuildConfig.DEBUG) plant(Timber.DebugTree())

        val navHost =
            supportFragmentManager.findFragmentById(R.id.main_nav_container) as NavHostFragment
        val navController = navHost.navController

        if (prefs.isNewUser) navController.navigate(R.id.onboardingPresentationFragment)
    }
}
