package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Match
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.view.MatchDetailFragment

class StatisticsMatchAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val match: Match,
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return MatchDetailFragment.newInstance(match)
    }
}
