package br.com.joaovitorqueiroz.footballapi.domain.usecases

import br.com.joaovitorqueiroz.footballapi.domain.mapper.toDomain
import br.com.joaovitorqueiroz.footballapi.domain.repository.FootballRepository
import br.com.joaovitorqueiroz.footballapi.ui.team.domain.model.Team
import javax.inject.Inject

interface GetTeamByIdUseCase {
    suspend operator fun invoke(id: Long): Team?
}

class GetTeamById @Inject constructor(
    private val repository: FootballRepository,
): GetTeamByIdUseCase {
    override suspend fun invoke(id: Long): Team? =
        repository.getTeam(id)?.toDomain()

}
