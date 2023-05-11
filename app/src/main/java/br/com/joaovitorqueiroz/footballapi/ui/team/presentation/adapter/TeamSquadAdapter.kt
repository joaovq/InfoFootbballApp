package br.com.joaovitorqueiroz.footballapi.ui.team.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.joaovitorqueiroz.footballapi.databinding.ItemPersonSquadBinding
import br.com.joaovitorqueiroz.footballapi.ui.team.domain.model.Person
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.gone

class TeamSquadAdapter : ListAdapter<Person, TeamSquadAdapter.TeamSquadViewHolder>(DiffItem) {
    inner class TeamSquadViewHolder(private val binding: ItemPersonSquadBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(person: Person, position: Int) {
            if (position == itemCount - 1) {
                binding.dividerPersonSquad.gone()
            }
            binding.person = person
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamSquadViewHolder {
        val binding: ItemPersonSquadBinding =
            ItemPersonSquadBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamSquadViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamSquadViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }

    object DiffItem : DiffUtil.ItemCallback<Person>() {
        override fun areItemsTheSame(oldItem: Person, newItem: Person): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Person, newItem: Person): Boolean =
            oldItem.id == newItem.id
    }
}
