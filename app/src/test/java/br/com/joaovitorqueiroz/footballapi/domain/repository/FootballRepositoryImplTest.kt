package br.com.joaovitorqueiroz.footballapi.domain.repository

import br.com.joaovitorqueiroz.footballapi.data.remotedatasource.data.RemoteDataSource
import br.com.joaovitorqueiroz.footballapi.data.remotedatasource.service.FootballService
import br.com.joaovitorqueiroz.footballapi.rule.TestDispatcherRule
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.Filters
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.ResultSet
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

internal class FootballRepositoryImplTest {
    @MockK
    private lateinit var infoFootballService: FootballService
    @MockK
    private lateinit var remoteDataSource: RemoteDataSource
    private lateinit var footballRepository: FootballRepository

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
        /*footballRepository = FootballRepositoryImpl(

        )*/
    }

    @Test
    fun `GIVEN service WHEN get all matches THEN list not null`() = runTest {
    }

    @Test
    fun `GIVEN service WHEN get all matches THEN list null`() = runTest {
    }
}
