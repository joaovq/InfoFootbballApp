package br.com.joaovitorqueiroz.footballapi.domain.usecases

import br.com.joaovitorqueiroz.footballapi.data.repository.FootballRepository
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.model.MatchList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface GetAllMatchesUseCase {
    suspend operator fun invoke(): MatchList?
}

class GetAllMatchesUseCaseImpl(
    private val footballRepository: FootballRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) : GetAllMatchesUseCase {
    override suspend operator fun invoke(): MatchList? =
        withContext(dispatcher) {
            return@withContext footballRepository.getAllMatch()
        }
}
