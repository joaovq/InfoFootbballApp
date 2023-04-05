package br.com.joaovitorqueiroz.footballapi.domain.usecases

import br.com.joaovitorqueiroz.footballapi.data.repository.FootballRepository
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.model.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Match
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GetMatchUseCase {
    suspend operator fun invoke(id: Long): Match?
}

class GetMatchUseCaseImpl(
    private val footballRepository: FootballRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default
): GetMatchUseCase {
    override suspend operator fun invoke(id: Long): Match? =
        withContext(dispatcher) {
            footballRepository.getMatch(id)
        }


}