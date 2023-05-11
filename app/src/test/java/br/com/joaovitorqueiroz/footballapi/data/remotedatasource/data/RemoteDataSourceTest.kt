package br.com.joaovitorqueiroz.footballapi.data.remotedatasource.data

import br.com.joaovitorqueiroz.footballapi.competitionList
import br.com.joaovitorqueiroz.footballapi.core.network.api.config.API_KEY_FOOTBALL
import br.com.joaovitorqueiroz.footballapi.data.remotedatasource.service.FootballService
import br.com.joaovitorqueiroz.footballapi.head2Head
import br.com.joaovitorqueiroz.footballapi.matchResponse
import br.com.joaovitorqueiroz.footballapi.rule.TestDispatcherRule
import br.com.joaovitorqueiroz.footballapi.teamResponse
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.Filters
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.ResultSet
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@OptIn(ExperimentalCoroutinesApi::class)
internal class RemoteDataSourceTest {
    @MockK
    private lateinit var infoFootballService: FootballService
    private lateinit var remoteDataSource: RemoteDataSource

    @get:Rule
    val testDispatcherRule = TestDispatcherRule()
    private val responseMatchList: Response<MatchList> = Response.success(
        MatchList(
            Filters(),
            ResultSet(),
            listOf(),
        ),
    )

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        remoteDataSource = RemoteDataSource(
            infoFootballService,
        )
    }

    @Test
    fun `GIVEN service WHEN get all matches THEN list not null`() = runTest {
        coEvery { infoFootballService.getMatches(API_KEY_FOOTBALL) } returns responseMatchList
        infoFootballService.getMatches(API_KEY_FOOTBALL)
        coVerify { infoFootballService.getMatches(API_KEY_FOOTBALL) }
        assertNotNull(remoteDataSource.getAll())
    }

    @Test
    fun `GIVEN service WHEN get all matches THEN list null`() = runTest {
        coEvery { infoFootballService.getMatches(API_KEY_FOOTBALL).body() } returns null
        infoFootballService.getMatches(API_KEY_FOOTBALL).body()
        coVerify { infoFootballService.getMatches(API_KEY_FOOTBALL).body() }
        assertNull(remoteDataSource.getAll())
    }

    @Test
    fun `GIVEN api token and id 1 WHEN get match by id THEN body not null`() = runTest {
        coEvery { infoFootballService.getMatch(API_KEY_FOOTBALL, 1).body() } returns matchResponse
        infoFootballService.getMatch(API_KEY_FOOTBALL, 1).body()
        coVerify { infoFootballService.getMatch(API_KEY_FOOTBALL, 1).body() }
        assertNotNull(infoFootballService.getMatch(API_KEY_FOOTBALL, 1).body())
    }

    @Test
    fun `GIVEN api token and id 1 WHEN get match by id THEN body null`() = runTest {
        coEvery { infoFootballService.getMatch(API_KEY_FOOTBALL, 1).body() } returns null
        infoFootballService.getMatch(API_KEY_FOOTBALL, 1).body()
        coVerify { infoFootballService.getMatch(API_KEY_FOOTBALL, 1).body() }
        assertNull(infoFootballService.getMatch(API_KEY_FOOTBALL, 1).body())
    }

    @Test
    fun `GIVEN api token and id 1 WHEN get head to head THEN body null`() = runTest {
        coEvery { infoFootballService.getMatchHead2Head(API_KEY_FOOTBALL, 1).body() } returns null
        infoFootballService.getMatchHead2Head(API_KEY_FOOTBALL, 1).body()
        coVerify { infoFootballService.getMatchHead2Head(API_KEY_FOOTBALL, 1).body() }
        assertNull(infoFootballService.getMatchHead2Head(API_KEY_FOOTBALL, 1).body())
    }

    @Test
    fun `GIVEN api token and id 1 WHEN get head to head THEN body not null`() = runTest {
        coEvery {
            infoFootballService.getMatchHead2Head(API_KEY_FOOTBALL, 1).body()
        } returns head2Head[0]
        infoFootballService.getMatchHead2Head(API_KEY_FOOTBALL, 1).body()
        coVerify { infoFootballService.getMatchHead2Head(API_KEY_FOOTBALL, 1).body() }
        assertNotNull(infoFootballService.getMatchHead2Head(API_KEY_FOOTBALL, 1).body())
    }

    @Test
    fun `GIVEN api token and id 1 WHEN get team by id THEN body null`() = runTest {
        coEvery { infoFootballService.getTeamById(API_KEY_FOOTBALL, 1).body() } returns null
        infoFootballService.getTeamById(API_KEY_FOOTBALL, 1).body()
        coVerify { infoFootballService.getTeamById(API_KEY_FOOTBALL, 1).body() }
        assertNull(infoFootballService.getTeamById(API_KEY_FOOTBALL, 1).body())
    }

    @Test
    fun `GIVEN api token and id 1 WHEN get team by id THEN body not null`() = runTest {
        coEvery { infoFootballService.getTeamById(API_KEY_FOOTBALL, 1).body() } returns teamResponse
        infoFootballService.getTeamById(API_KEY_FOOTBALL, 1).body()
        coVerify { infoFootballService.getTeamById(API_KEY_FOOTBALL, 1).body() }
        assertNotNull(infoFootballService.getTeamById(API_KEY_FOOTBALL, 1).body())
    }

    @Test
    fun `GIVEN api token WHEN get competitions THEN body not null`() = runTest {
        coEvery {
            infoFootballService.getCompetitions(API_KEY_FOOTBALL).body()
        } returns competitionList
        infoFootballService.getCompetitions(API_KEY_FOOTBALL).body()
        coVerify { infoFootballService.getCompetitions(API_KEY_FOOTBALL).body() }
        assertNotNull(infoFootballService.getCompetitions(API_KEY_FOOTBALL).body())
    }

    @Test
    fun `GIVEN api token WHEN get competitions THEN body null`() = runTest {
        coEvery { infoFootballService.getCompetitions(API_KEY_FOOTBALL).body() } returns null
        infoFootballService.getCompetitions(API_KEY_FOOTBALL).body()
        coVerify { infoFootballService.getCompetitions(API_KEY_FOOTBALL).body() }
        assertNull(infoFootballService.getCompetitions(API_KEY_FOOTBALL).body())
    }
}
