package br.com.joaovitorqueiroz.footballapi.ui.util.databinding

import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.adapter.MatchItemAdapter
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Score
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Match
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.gone
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.loadImage
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.visible

@BindingAdapter("urlImg")
fun loadImage(imageView: AppCompatImageView?, url: String?) {
    url?.let { imageView?.loadImage(url = it) }
}

@BindingAdapter("textScore")
fun bindTextScore(text: TextView, score: Score?) {
    score?.let {
        val home: Int? = score.fullTime.home ?: score.halfTime.home
        val away: Int? = score.fullTime.away ?: score.halfTime.away
        home?.let {
            text.text = text.context.getString(R.string.text_score_item_match, home, away)
        }
    }
}

@BindingAdapter("matchesData")
fun bindMatchesList(recyclerView: RecyclerView, matches: List<Match>?) {
    matches?.let { safeList ->
        val adapter = recyclerView.adapter as MatchItemAdapter
        adapter.submitList(safeList)
    }
}

@BindingAdapter("visibilityView")
fun bindVisibilityView(view: View, isVisible: Boolean?) {
    isVisible?.let {
        if (it) view.visible() else view.gone()
    }
}
