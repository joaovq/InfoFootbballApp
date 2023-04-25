package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import br.com.joaovitorqueiroz.footballapi.databinding.FragmentMatchDetailBinding
import br.com.joaovitorqueiroz.footballapi.domain.mapper.toMatch
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Match
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.viewmodel.MatchViewModel
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.snackbar
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

const val ARG_MATCH = "matchId"

@AndroidEntryPoint
class MatchDetailFragment : Fragment() {
    private lateinit var _binding: FragmentMatchDetailBinding
    private var param: Match? = null
    private val matchViewModel: MatchViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {
            param = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getSerializable(ARG_MATCH, Match::class.java)
            } else {
                it.getSerializable(ARG_MATCH) as Match
            }
        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMatchDetailBinding.inflate(inflater, container, false)
        _binding.lifecycleOwner = viewLifecycleOwner
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*param?.let {
            _binding.match = it
        }*/
        /*TODO compartilhar o view model*/
        matchViewModel.match.observe(viewLifecycleOwner) {
            it?.let { safeState ->
                when (safeState) {
                    is MatchViewModel.MatchUIState.Error -> {
                        safeState.exception.printStackTrace()
                        snackbar(message = safeState.message)
                    }

                    is MatchViewModel.MatchUIState.Success<MatchResponse?> -> {
                        Timber.tag("data").d("%s", safeState.data.toString())
                        safeState.data?.toMatch()?.let { safeMatch ->
                            _binding.match = safeMatch
                            /*setUpViewPager(safeMatch)*/
                        }
                    }
                }
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance(match: Match) =
            MatchDetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_MATCH, match)
                }
            }
    }
}
