package br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse

import com.google.gson.annotations.SerializedName
import java.util.Date

data class ContractPersonResponse(
    @SerializedName("start")
    val start: String?,
    @SerializedName("until")
    val until: String?
)
