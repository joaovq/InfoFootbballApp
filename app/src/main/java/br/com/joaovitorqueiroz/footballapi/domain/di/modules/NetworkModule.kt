package br.com.joaovitorqueiroz.footballapi.domain.di.modules

import br.com.joaovitorqueiroz.footballapi.core.network.api.factory.UrlFactory
import br.com.joaovitorqueiroz.footballapi.data.remotedatasource.service.FootballService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
    @Singleton
    @Provides
    fun providesRetrofit(): FootballService =
        Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(UrlFactory.BASE_URL)
            .build()
            .create(FootballService::class.java)
}
