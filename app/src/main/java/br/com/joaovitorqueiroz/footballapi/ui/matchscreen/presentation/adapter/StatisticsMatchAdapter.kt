package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.factory.Statistics

data class StatisticsMatchAdapter(
    val fragmentManager: FragmentManager,
    val lifecycle: Lifecycle,
    val listFactory: List<Statistics>
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = listFactory.size

    override fun createFragment(position: Int): Fragment {
        return listFactory[position].fragment
    }
}
