package br.com.joaovitorqueiroz.footballapi.ui.util.databinding

import android.app.Dialog
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.domain.mapper.toMapperCompetition
import br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.adapter.CompetitionItemAdapter
import br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.adapter.MatchItemAdapter
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.viewmodel.MatchesUIState
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Score
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.model.Match
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.loadImage
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.showProgressDialog

@BindingAdapter("listData", "stateProgress")
fun bindMatchesList(
    recyclerView: RecyclerView,
    matchesList: MatchesUIState?,
    customProgress: Dialog,
) {
    matchesList?.let { safeState ->
        when (safeState) {
            is MatchesUIState.Error -> {
                customProgress.hide()
                safeState.exception.printStackTrace()
            }
            MatchesUIState.Loading -> {
                customProgress.showProgressDialog()
            }
            is MatchesUIState.Success<*> -> {
                customProgress.hide()
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter =
                    CompetitionItemAdapter(safeState.data as MatchList, recyclerView.context)
                val adapter = recyclerView.adapter as CompetitionItemAdapter
                adapter.submitList(
                    safeState.data.matches.toMapperCompetition()?.toList(),
                )
            }
        }
    }
}

@BindingAdapter("urlImg")
fun loadImage(imageView: AppCompatImageView?, url: String) {
    imageView?.loadImage(url = url)
}

@BindingAdapter("textScore")
fun bindTextScore(text: TextView, score: Score) {
    val home: Int? = score.fullTime.home ?: score.halfTime.home
    val away: Int? = score.fullTime.away ?: score.halfTime.away
    home?.let {
        text.text = text.context.getString(R.string.text_score_item_match, home, away)
    }
}

@BindingAdapter("matchesData")
fun bindMatchesList(recyclerView: RecyclerView, matches: List<Match>?) {
    matches?.let { safeList ->
        val adapter = recyclerView.adapter as MatchItemAdapter
        adapter.submitList(safeList)
    }
}
