package br.com.joaovitorqueiroz.footballapi.ui.matches.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ResultSet(
    val count: Int = 0,
    val competitions: String = "",
    @SerializedName("first")
    val first: Date = Date(),
    @SerializedName("last")
    val last: Date = Date(),
    val played: Int = 0
)
