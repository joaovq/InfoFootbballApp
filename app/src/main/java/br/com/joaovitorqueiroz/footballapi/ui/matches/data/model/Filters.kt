package br.com.joaovitorqueiroz.footballapi.ui.matches.data.model

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp
import java.util.*

data class Filters(
    @SerializedName("dateFrom")
    val dateFrom: Timestamp = Timestamp(0),
    @SerializedName("dateTo")
    val dateTo: Timestamp = Timestamp(0),
    val permission: String = "",
)
