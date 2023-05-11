package br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.joaovitorqueiroz.footballapi.databinding.ItemMatchesCompetitionBinding
import br.com.joaovitorqueiroz.footballapi.domain.mapper.toCompetition
import br.com.joaovitorqueiroz.footballapi.domain.mapper.toMatch
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.CompetitionResponse

class CompetitionItemAdapter(
    private val matches: MatchList,
    private val onClickItem: (id: Long) -> Unit,
) : ListAdapter<CompetitionResponse, CompetitionItemAdapter.CompetitionViewHolder>(DiffItemCallback) {
    inner class CompetitionViewHolder(
        private val binding: ItemMatchesCompetitionBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        private val pool = RecyclerView.RecycledViewPool()

        init {
            binding.rvMatches.adapter = MatchItemAdapter(action = onClickItem)
            binding.rvMatches.setRecycledViewPool(pool)
            binding.rvMatches.setHasFixedSize(true)
        }

        fun bind(competitionResponse: CompetitionResponse) {
            val matchesCompetition =
                matches.matches.filter { it?.competition?.id == competitionResponse.id }.filterNotNull()
            binding.competition = competitionResponse.toCompetition()
            binding.matchList = matchesCompetition.map { it.toMatch() }.sortedBy { it.matchDay }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionViewHolder {
        val binding =
            ItemMatchesCompetitionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        return CompetitionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompetitionViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    object DiffItemCallback : DiffUtil.ItemCallback<CompetitionResponse>() {
        override fun areItemsTheSame(oldItem: CompetitionResponse, newItem: CompetitionResponse): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: CompetitionResponse, newItem: CompetitionResponse): Boolean =
            oldItem.id == newItem.id
    }
}
