package br.com.joaovitorqueiroz.footballapi.domain.mapper

import br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse.CoachResponse
import br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse.ContractPersonResponse
import br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse.PersonResponse
import br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse.TeamResponse
import br.com.joaovitorqueiroz.footballapi.ui.team.domain.model.Coach
import br.com.joaovitorqueiroz.footballapi.ui.team.domain.model.ContractPerson
import br.com.joaovitorqueiroz.footballapi.ui.team.domain.model.Person
import br.com.joaovitorqueiroz.footballapi.ui.team.domain.model.Team
import java.util.Date

fun TeamResponse.toDomain() = Team(
    this.area.toArea(),
    this.id ?: 0,
    this.name ?: "",
    this.shortName ?: "",
    this.tla ?: "",
    this.crest ?: "",
    this.address ?: "",
    this.website ?: "",
    this.founded ?: 0,
    this.clubColors ?: "",
    this.venue ?: "",
    this.runningCompetitions?.map { it.toCompetition() } ?: emptyList(),
    this.coach.toDomain(),
    this.squad?.map { it.toDomain() } ?: emptyList(),
    this.lastUpdated ?: Date(),
)
fun CoachResponse?.toDomain() = Coach(
    this?.id ?: 0,
    this?.firstName ?: "",
    this?.name ?: "",
    this?.lastName ?: "",
    this?.dateOfBirth ?: Date(),
    this?.nationality ?: "",
    this?.contract.toDomain()
)

fun ContractPersonResponse?.toDomain() = ContractPerson(
    this?.start ?: "",
    this?.until ?: ""
)

fun PersonResponse.toDomain() = Person(
    this.id ?: 0,
    this.name ?: "",
    this.position ?: "",
    this.dateOfBirth ?: Date(),
    this.nationality ?: ""
)
