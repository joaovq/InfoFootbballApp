package br.com.joaovitorqueiroz.footballapi.domain.usecases

import br.com.joaovitorqueiroz.footballapi.domain.repository.FootballRepository
import br.com.joaovitorqueiroz.footballapi.rule.TestDispatcherRule
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.Filters
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.ResultSet
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.withContext
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)

internal class GetAllMatchesUseCaseImplTest {
    private val matchList = MatchList(Filters(), ResultSet(), emptyList())

    @get:Rule
    val testDispatcherRule = TestDispatcherRule()

    @MockK
    private lateinit var repository: FootballRepository

    private lateinit var getAllMatchesUseCase: GetAllMatchesUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        getAllMatchesUseCase = GetAllMatchesUseCaseImpl(
            repository,
            UnconfinedTestDispatcher(),
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        unmockkAll()
    }

    @Test
    fun `GIVEN repository WHEN get all matches THEN return matchList`() = runTest {
        coEvery { repository.getAllMatch() } returns matchList
        val matchListResult = withContext(UnconfinedTestDispatcher()) { getAllMatchesUseCase() }
        coVerify { repository.getAllMatch() }
        assertThat(matchListResult).isEqualTo(matchList)
        println("match result: $matchListResult")
        println("match: $matchList")
    }
}
