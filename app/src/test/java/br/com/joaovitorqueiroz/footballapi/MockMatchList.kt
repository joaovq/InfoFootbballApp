package br.com.joaovitorqueiroz.footballapi

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.Filters
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.ResultSet
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.AreaResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.AwayTeamResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.CompetitionResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.FullTimeResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.GroupResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.HalfTimeResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.HomeTeamResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.ScoreResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.SeasonResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.StageResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.StatusResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.WinnerResponse
import java.util.Date

val matches: List<MatchResponse> = listOf(
    MatchResponse(
        1,
        AreaResponse(1, "Brazil", "BR", "www.flag.com"),
        CompetitionResponse(
            1,
            AreaResponse(1, "Brazil", "BR", "www.flag.com"),
            "Campeonato brasileiro da serie B",
            "BSB",
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
            1,
            "Esporte Clube Vitória",
            "EC Vitória",
            "ECV",
            "www.crest.com",
            null,
            null,
            null,
        ),
        AwayTeamResponse(
            2,
            "Ponte Preta",
            "Ponte Preta",
            "PTP",
            "www.crest.com",
            null,
            null,
            null,
        ),
    ),
    MatchResponse(
        2,
        AreaResponse(1, "Brazil", "BR", "www.flag.com"),
        CompetitionResponse(
            1,
            AreaResponse(1, "Brazil", "BR", "www.flag.com"),
            "Campeonato brasileiro da serie B",
            "BSB",
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
            56,
            "Esporte Clube Vitória",
            "EC Vitória",
            "ECV",
            "www.crest.com",
            null,
            null,
            null,
        ),
        AwayTeamResponse(
            10,
            "Ponte Preta",
            "Ponte Preta",
            "PTP",
            "www.crest.com",
            null,
            null,
            null,
        ),
    ),
)

val matchResponse = MatchResponse(
    2,
    AreaResponse(1, "Brazil", "BR", "www.flag.com"),
    CompetitionResponse(
        1,
        AreaResponse(1, "Brazil", "BR", "www.flag.com"),
        "Campeonato brasileiro da serie B",
        "BSB",
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
        56,
        "Esporte Clube Vitória",
        "EC Vitória",
        "ECV",
        "www.crest.com",
        null,
        null,
        null,
    ),
    AwayTeamResponse(
        10,
        "Ponte Preta",
        "Ponte Preta",
        "PTP",
        "www.crest.com",
        null,
        null,
        null,
    ),
)

val matchList = MatchList(
    Filters(),
    ResultSet(),
    matches,
)

