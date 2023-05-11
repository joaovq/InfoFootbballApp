package br.com.joaovitorqueiroz.footballapi.domain.repository

import br.com.joaovitorqueiroz.footballapi.data.api.FakeApiService
import br.com.joaovitorqueiroz.footballapi.head2Head
import br.com.joaovitorqueiroz.footballapi.matchList
import br.com.joaovitorqueiroz.footballapi.rule.TestDispatcherRule
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
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.Date

@OptIn(ExperimentalCoroutinesApi::class)
internal class FootballRepositoryTest {
    private val newMatch = MatchResponse(
        1,
        AreaResponse(1, "Brazil", "BR", "www.flag.com"),
        CompetitionResponse(
            1,
            AreaResponse(1, "Brazil", "BR", "www.flag.com"),
            "Champions League",
            "CHA",
            "CUP",
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
            "Footbal club Barcelona",
            "FC Barcelona",
            "FCB",
            "www.crest.com",
            null,
            null,
            null,
        ),
        AwayTeamResponse(
            2,
            "Bayern Munchen",
            "Bayern",
            "FCB",
            "www.crest.com",
            null,
            null,
            null,
        ),
    )

    val newMatches = listOf(
        newMatch,
    )

    @get:Rule
    val testDispatcherRule = TestDispatcherRule()

    private lateinit var footballRepository: FakeFootballRepository

    @Before
    fun init() {
        footballRepository = FakeFootballRepository(
            FakeApiService(
                matchList,
                head2Head,
            ),
        )
    }

    @Test
    fun `test get matches`() = runTest(UnconfinedTestDispatcher()) {
        val list = withContext(UnconfinedTestDispatcher()) { footballRepository.getAllMatch() }
        advanceUntilIdle()
        assertThat(
            list,
        ).isEqualTo(matchList)
    }

    @Test
    fun test_get_match_response() = runTest {
//        GIVEN
        val matchResponse =
            withContext(UnconfinedTestDispatcher()) { footballRepository.getMatch(1) }
//       THEN
        assertThat(matchResponse).isEqualTo(matchList.matches[0])
    }

    @Test
    fun test_get_match_head_to_head() = runTest {
//        GIVEN
        val head2HeadResponse =
            withContext(UnconfinedTestDispatcher()) { footballRepository.getHead2Head(1) }
//        THEN
        println(head2HeadResponse)
        assertThat(head2HeadResponse).isEqualTo(head2Head[0])
    }
}
