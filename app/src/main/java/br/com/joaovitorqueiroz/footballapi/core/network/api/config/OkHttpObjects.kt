package br.com.joaovitorqueiroz.footballapi.core.network.api.config

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

val interceptor = HttpLoggingInterceptor { message ->
    Timber.d(message)
}
val httpClient = OkHttpClient
    .Builder()
    .addInterceptor(interceptor = interceptor).build()
