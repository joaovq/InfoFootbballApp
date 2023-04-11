package br.com.joaovitorqueiroz.footballapi.ui.matches.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.joaovitorqueiroz.footballapi.databinding.ItemMatchesCompetitionBinding
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.model.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Competition

class CompetitionItemAdapter(
    private val matches: MatchList,
    private val context: Context
) : ListAdapter<Competition, CompetitionItemAdapter.CompetitionViewHolder>(DiffItemCallback) {
    inner class CompetitionViewHolder(
        private val binding: ItemMatchesCompetitionBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        private val pool = RecyclerView.RecycledViewPool()

        init {
            binding.rvMatches.adapter = MatchItemAdapter(context)
            binding.rvMatches.setRecycledViewPool(pool)
        }

        fun bind(competition: Competition) {
            val matchesCompetition =
                matches.matches.filter { it?.competition?.id == competition.id }.filterNotNull()
            binding.competition = competition
            binding.matchList = matchesCompetition
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

    object DiffItemCallback : DiffUtil.ItemCallback<Competition>() {
        override fun areItemsTheSame(oldItem: Competition, newItem: Competition): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Competition, newItem: Competition): Boolean =
            oldItem.id == newItem.id
    }
}
