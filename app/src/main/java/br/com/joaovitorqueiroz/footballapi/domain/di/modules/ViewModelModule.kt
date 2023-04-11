package br.com.joaovitorqueiroz.footballapi.domain.di.modules

import br.com.joaovitorqueiroz.footballapi.data.repository.FootballRepository
import br.com.joaovitorqueiroz.footballapi.data.repository.FootballRepositoryImpl
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetAllMatchesUseCase
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetAllMatchesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {
    @Binds
    abstract fun bindFootballRepository(
        footballRepositoryImpl: FootballRepositoryImpl,
    ): FootballRepository

    @Binds
    abstract fun bindGetAllMatches(
        getAllMatchesUseCase: GetAllMatchesUseCaseImpl,
    ): GetAllMatchesUseCase
}
