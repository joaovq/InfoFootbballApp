package br.com.joaovitorqueiroz.footballapi.ui.matches.data.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ResultSet(
    val count: Int,
    val competitions: String,
    @SerializedName("first")
    val first: Date,
    @SerializedName("last")
    val last: Date,
    val played: Int
)
