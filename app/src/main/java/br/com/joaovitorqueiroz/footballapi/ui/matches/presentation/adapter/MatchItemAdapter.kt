package br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.joaovitorqueiroz.footballapi.databinding.ItemsMatchBinding
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Match

class MatchItemAdapter(private val action: (id: Long) -> Unit) :
    ListAdapter<Match, MatchItemAdapter.MatchViewHolder>(DiffItemCallback) {
    inner class MatchViewHolder(
        private val binding: ItemsMatchBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(match: Match) {
            binding.tvScore.text = " X "
            binding.match = match
            binding.root.setOnClickListener {
                action(match.id)
            }
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val binding =
            ItemsMatchBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    object DiffItemCallback : DiffUtil.ItemCallback<Match>() {
        override fun areItemsTheSame(oldItem: Match, newItem: Match): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Match, newItem: Match): Boolean =
            oldItem.id == newItem.id
    }
}
