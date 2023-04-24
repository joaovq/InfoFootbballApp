package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model

import java.io.Serializable

data class AwayTeam(
    val id: Long,
    val name: String,
    val shortName: String,
    val tla: String,
    val crest: String,
    val wins: Int?,
    val draws: Int?,
    val losses: Int?
) : Serializable
