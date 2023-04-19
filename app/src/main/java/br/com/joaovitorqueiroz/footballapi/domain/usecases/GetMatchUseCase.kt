package br.com.joaovitorqueiroz.footballapi.domain.usecases

import br.com.joaovitorqueiroz.footballapi.data.repository.FootballRepository
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GetMatchUseCase {
    suspend operator fun invoke(id: Long): MatchResponse?
}

class GetMatchUseCaseImpl(
    private val footballRepository: FootballRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
): GetMatchUseCase {
    override suspend operator fun invoke(id: Long): MatchResponse? =
        withContext(dispatcher) {
            footballRepository.getMatch(id)
        }


}