package br.com.joaovitorqueiroz.footballapi.domain.di.modules

import br.com.joaovitorqueiroz.footballapi.domain.repository.FootballRepository
import br.com.joaovitorqueiroz.footballapi.domain.repository.FootballRepositoryImpl
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetAllMatchesUseCase
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetAllMatchesUseCaseImpl
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetMatchHead2Head
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetMatchHead2HeadUseCase
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetMatchUseCase
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetMatchUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
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
    @Binds
    abstract fun bindGetMatch(
        getMatchUseCase: GetMatchUseCaseImpl,
    ): GetMatchUseCase
    @Binds
    abstract fun bindGetHead2Head(
        getMatchHead2Head: GetMatchHead2Head,
    ): GetMatchHead2HeadUseCase
}
