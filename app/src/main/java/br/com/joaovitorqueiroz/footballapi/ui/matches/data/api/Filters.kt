package br.com.joaovitorqueiroz.footballapi.ui.matches.data.api

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp
import java.util.*

data class Filters(
    @SerializedName("dateFrom")
    val dateFrom: Timestamp? = null,
    @SerializedName("dateTo")
    val dateTo: Timestamp? = null,
    val permission: String = "",
)
