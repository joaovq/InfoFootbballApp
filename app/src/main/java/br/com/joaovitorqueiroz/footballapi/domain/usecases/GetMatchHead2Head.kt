package br.com.joaovitorqueiroz.footballapi.domain.usecases

import br.com.joaovitorqueiroz.footballapi.domain.di.modules.DefaultDispatcher
import br.com.joaovitorqueiroz.footballapi.domain.repository.FootballRepository
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface GetMatchHead2HeadUseCase {
    suspend operator fun invoke(matchId: Long): Head2HeadResponse?
}

class GetMatchHead2Head @Inject constructor(
    private val footballRepository: FootballRepository,
    @DefaultDispatcher private val dispatcher: CoroutineDispatcher,
) : GetMatchHead2HeadUseCase {
    override suspend operator fun invoke(matchId: Long): Head2HeadResponse? = withContext(dispatcher) {
        footballRepository.getHead2Head(matchId)
    }
}
