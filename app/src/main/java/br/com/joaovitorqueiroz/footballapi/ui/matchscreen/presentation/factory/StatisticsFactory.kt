package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.factory

import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.view.MatchDetailFragment
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.view.MatchPersonFragment

object StatisticsFactory {
    fun createListFragmentsStatistics() = listOf(
        Statistics(
            fragment = MatchDetailFragment(),
            R.drawable.ic_ball_logo,
        ),
        Statistics(
            fragment = MatchPersonFragment(),
            icon = R.drawable.ic_profile,
        ),
    )
}
