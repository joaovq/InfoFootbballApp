package br.com.joaovitorqueiroz.footballapi.domain.usecases

import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import io.mockk.coEvery
import io.mockk.mockk
import org.junit.Test

internal class GetAllMatchesUseCaseImplTest {
    @Test
    fun testInvoke() {
//        when
        val matchList = MatchList()
        val useCaseImpl: GetAllMatchesUseCaseImpl = mockk()
//        while
        coEvery { useCaseImpl() } returns matchList
//        then
    }
}
