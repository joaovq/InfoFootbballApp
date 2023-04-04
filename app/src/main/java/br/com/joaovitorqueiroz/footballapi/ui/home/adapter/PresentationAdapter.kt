package br.com.joaovitorqueiroz.footballapi.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.joaovitorqueiroz.footballapi.databinding.PresentationItemBinding
import br.com.joaovitorqueiroz.footballapi.ui.home.model.Presentation

class PresentationAdapter :
    ListAdapter<Presentation, PresentationAdapter.PresentationViewHolder>(DiffUtilCallback) {
    inner class PresentationViewHolder(private val binding: PresentationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(presentation: Presentation) {
            binding.ivPresentation.setImageResource(presentation.image)
            binding.tvDescriptionPresentation.text = presentation.description
            binding.tvTitlePresentation.text = presentation.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresentationViewHolder {
        val binding =
            PresentationItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            )
        return PresentationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PresentationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    object DiffUtilCallback : DiffUtil.ItemCallback<Presentation>() {
        override fun areItemsTheSame(oldItem: Presentation, newItem: Presentation): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: Presentation, newItem: Presentation): Boolean =
            oldItem.title == newItem.title && oldItem.image == newItem.image &&
                oldItem.description == newItem.description
    }
}
