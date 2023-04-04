package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Season(
    val id: Long,
    @SerializedName("startDate")
    val startDate: Date,
    @SerializedName("endDate")
    val endDate: Date,
    @SerializedName("currentMatchday")
    val currentlyMatchDay: Int,
    val winner: String?
)
