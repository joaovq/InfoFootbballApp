package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model

import java.io.Serializable
import java.util.Date

data class Season(
    val id: Long,
    val startDate: Date,
    val endDate: Date,
    val currentlyMatchDay: Int,
    val winner: String?
) : Serializable
