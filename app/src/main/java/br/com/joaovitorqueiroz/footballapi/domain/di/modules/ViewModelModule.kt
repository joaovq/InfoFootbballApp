package br.com.joaovitorqueiroz.footballapi.domain.di.modules

import br.com.joaovitorqueiroz.footballapi.domain.repository.FootballRepository
import br.com.joaovitorqueiroz.footballapi.domain.repository.FootballRepositoryImpl
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetAllMatchesUseCase
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetAllMatchesUseCaseImpl
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetMatchHead2Head
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetMatchHead2HeadUseCase
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetMatchUseCase
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetMatchUseCaseImpl
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetTeamById
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetTeamByIdUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelModule {
    @Binds
    @ViewModelScoped
    abstract fun bindFootballRepository(
        footballRepositoryImpl: FootballRepositoryImpl,
    ): FootballRepository

    @Binds
    @ViewModelScoped
    abstract fun bindGetAllMatches(
        getAllMatchesUseCase: GetAllMatchesUseCaseImpl,
    ): GetAllMatchesUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetMatch(
        getMatchUseCase: GetMatchUseCaseImpl,
    ): GetMatchUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetHead2Head(
        getMatchHead2Head: GetMatchHead2Head,
    ): GetMatchHead2HeadUseCase

    @Binds
    @ViewModelScoped
    abstract fun bindGetTeam(
        getTeamById: GetTeamById,
    ): GetTeamByIdUseCase
}
