package br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse

import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.AreaResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.CompetitionResponse
import com.google.gson.annotations.SerializedName
import java.util.Date

data class TeamResponse(
    val area: AreaResponse,
    val id: Long?,
    val name: String?,
    val shortName: String?,
    val tla: String?,
    val crest: String?,
    val address: String?,
    val website: String?,
    val founded: Int?,
    val clubColors: String?,
    val venue: String?,
    val runningCompetitions: List<CompetitionResponse>?,
    val coach: CoachResponse?,
    val squad: List<PersonResponse>?,
    @SerializedName("lastUpdated")
    val lastUpdated: Date?,
)
