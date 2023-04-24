package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api

import com.google.gson.annotations.SerializedName
import java.util.*

data class SeasonResponse(
    val id: Long,
    @SerializedName("startDate")
    val startDate: Date,
    @SerializedName("endDate")
    val endDate: Date,
    @SerializedName("currentMatchday")
    val currentlyMatchDay: Int,
    val winner: String?
)
