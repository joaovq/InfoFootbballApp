package br.com.joaovitorqueiroz.footballapi

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.CompetitionList
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.Filters
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.AggregatesResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.AreaResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.AwayTeamResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.CompetitionResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.FullTimeResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.GroupResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.HalfTimeResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.HomeTeamResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.ScoreResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.SeasonResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.StageResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.StatusResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.WinnerResponse
import br.com.joaovitorqueiroz.footballapi.ui.team.data.apiresponse.TeamResponse
import java.util.Date

val mockAggregates = AggregatesResponse(
    20,
    90,
    HomeTeamResponse(
        2,
        "Sport Club Palmeiras",
        "SC Palmeiras",
        "PAL",
        "www.crest.com.br",
        6,
        6,
        3,
    ),
    AwayTeamResponse(
        40,
        "Clube Regatas Flamengo",
        "CR Flamengo",
        "FLA",
        "www.crest.com.br",
        3,
        6,
        6,
    ),
)

val head2Head = listOf(
    Head2HeadResponse(
        null,
        null,
        mockAggregates,
        listOf(
            MatchResponse(
                1,
                AreaResponse(1, "Brazil", "BR", "www.flag.com"),
                CompetitionResponse(
                    1,
                    AreaResponse(1, "Brazil", "BR", "www.flag.com"),
                    "Campeonato brasileiro da serie A",
                    "BSA",
                    "LEAGUE",
                    "www.emblem.com.br",
                ),
                StatusResponse.IN_PLAY,
                StageResponse.REGULAR_SEASON,
                SeasonResponse(
                    1,
                    Date(),
                    Date(),
                    1,
                    "HOME",
                ),
                ScoreResponse(
                    WinnerResponse.HOME,
                    "REGULAR",
                    FullTimeResponse(1, 0),
                    HalfTimeResponse(3, 0),
                ),
                GroupResponse.GROUP_L,
                1,
                Date(),
                HomeTeamResponse(
                    2,
                    "Sport Club Palmeiras",
                    "SC Palmeiras",
                    "PAL",
                    "www.crest.com.br",
                    6,
                    6,
                    3,
                ),
                AwayTeamResponse(
                    40,
                    "Clube Regatas Flamengo",
                    "CR Flamengo",
                    "FLA",
                    "www.crest.com.br",
                    3,
                    6,
                    6,
                ),
            ),
        ),
    ),
)

val teamResponse = TeamResponse(
    AreaResponse(1, "Brazil", "BR", "www.flag.com"),
    2,
    "Sport Club Palmeiras",
    "SC Palmeiras",
    "PAL",
    "www.crest.com.br",
    "",
    "",
    3,
    "",
    "",
    null,
    null,
    null,
    null,
)

val competitionList =
    CompetitionList(
        10,
        Filters(),
        listOf(
            CompetitionResponse(
                1,
                AreaResponse(1, "Brazil", "BR", "www.flag.com"),
                "Campeonato brasileiro da serie A",
                "BSA",
                "LEAGUE",
                "www.emblem.com.br",
            ),
        ),
    )
