package br.com.joaovitorqueiroz.footballapi.core.network.api.config

import br.com.joaovitorqueiroz.footballapi.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val API_KEY_FOOTBALL = BuildConfig.API_KEY_FOOTBALL
class RetrofitConfig {
    companion object {
        @Volatile
        private var instance: Retrofit? = null
        fun getInstance(baseUrl: String): Retrofit {
            if (instance == null) {
                instance = Retrofit
                    .Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return instance as Retrofit
        }
    }
}
