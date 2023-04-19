package br.com.joaovitorqueiroz.footballapi.domain.usecases

import br.com.joaovitorqueiroz.footballapi.data.repository.FootballRepository
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetAllMatchesUseCase {
    suspend operator fun invoke(): MatchList?
}

class GetAllMatchesUseCaseImpl @Inject constructor(
    private val footballRepository: FootballRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
) : GetAllMatchesUseCase {
    override suspend operator fun invoke(): MatchList? =
        withContext(dispatcher) {
            return@withContext footballRepository.getAllMatch()
        }
}
