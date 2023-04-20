package br.com.joaovitorqueiroz.footballapi

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import br.com.joaovitorqueiroz.footballapi.databinding.ActivitySplashScreenBinding
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.viewBinding
import br.com.joaovitorqueiroz.footballapi.util.extension.animViewbyId

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {
    private val binding: ActivitySplashScreenBinding by
        viewBinding(ActivitySplashScreenBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivLogo.animViewbyId(applicationContext)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }, 2000)
    }
}
