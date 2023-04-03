package br.com.joaovitorqueiroz.footballapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import br.com.joaovitorqueiroz.footballapi.core.network.api.config.API_KEY_FOOTBALL
import br.com.joaovitorqueiroz.footballapi.databinding.ActivityMainBinding
import br.com.joaovitorqueiroz.footballapi.util.extension.viewBinding
import kotlinx.coroutines.launch
import timber.log.Timber
import timber.log.Timber.Forest.plant

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (BuildConfig.DEBUG) {
            plant(Timber.DebugTree())
        }
        val service = (application as InfoFootballApplication).appContainer.service
        lifecycleScope.launch {
            Timber.tag("data test").d(service.getMatches(API_KEY_FOOTBALL).body().toString())
        }
    }
}
