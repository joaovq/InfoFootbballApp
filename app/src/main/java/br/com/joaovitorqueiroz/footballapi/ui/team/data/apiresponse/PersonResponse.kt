package br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse

import com.google.gson.annotations.SerializedName
import java.util.Date

data class PersonResponse(
    val id: Long?,
    val name: String?,
    val position: String?,
    @SerializedName("dateOfBirth")
    val dateOfBirth: Date?,
    val nationality: String?,
)
