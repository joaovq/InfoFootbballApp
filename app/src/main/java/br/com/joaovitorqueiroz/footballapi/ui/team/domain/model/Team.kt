package br.com.joaovitorqueiroz.footballapi.ui.team.domain.model

import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Area
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Competition
import java.util.Date

data class Team(
    val area: Area,
    val id: Long,
    val name: String,
    val shortName: String,
    val tla: String,
    val crest: String,
    val address: String,
    val website: String,
    val founded: Int,
    val clubColors: String,
    val venue: String,
    val runningCompetitions: List<Competition>,
    val coach: Coach,
    val squad: List<Person>,
    val lastUpdated: Date,
)
