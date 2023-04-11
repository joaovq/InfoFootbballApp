package br.com.joaovitorqueiroz.footballapi.ui.util.databinding

import android.app.Dialog
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.domain.mapper.toMapperCompetition
import br.com.joaovitorqueiroz.footballapi.ui.matches.adapter.CompetitionItemAdapter
import br.com.joaovitorqueiroz.footballapi.ui.matches.adapter.MatchItemAdapter
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.model.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matches.viewmodel.MatchesUIState
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Match
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.model.Score
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
                /* snackbar(message = safeState.message, anchor = R.id.bottom_navigation)*/
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
    val home: Int?
    val away: Int?
    if (score.winner != null) {
        home = score.fullTime.home
        away = score.fullTime.away
    } else {
        home = score.halfTime.home
        away = score.halfTime.away
    }
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
