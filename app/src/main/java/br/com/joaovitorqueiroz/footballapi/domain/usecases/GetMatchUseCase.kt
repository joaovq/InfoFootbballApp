package br.com.joaovitorqueiroz.footballapi.domain.usecases

import br.com.joaovitorqueiroz.footballapi.domain.di.modules.DefaultDispatcher
import br.com.joaovitorqueiroz.footballapi.domain.repository.FootballRepository
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetMatchUseCase {
    suspend operator fun invoke(id: Long): MatchResponse?
}

class GetMatchUseCaseImpl @Inject constructor(
    private val footballRepository: FootballRepository,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher = Dispatchers.Default
): GetMatchUseCase {
    override suspend operator fun invoke(id: Long): MatchResponse? =
        withContext(dispatcher) {
            footballRepository.getMatch(id)
        }


}