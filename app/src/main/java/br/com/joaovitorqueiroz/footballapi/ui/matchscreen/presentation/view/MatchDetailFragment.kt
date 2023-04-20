package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import br.com.joaovitorqueiroz.footballapi.databinding.FragmentMatchDetailBinding
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Match
import dagger.hilt.android.AndroidEntryPoint

const val ARG_MATCH = "matchId"

@AndroidEntryPoint
class MatchDetailFragment : Fragment() {
    private lateinit var _binding: FragmentMatchDetailBinding
    private var param: Match? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                it.getSerializable(ARG_MATCH, Match::class.java)
            } else {
                it.getSerializable(ARG_MATCH) as Match
            }
        }
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
        param?.let {
            _binding.match = it
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
