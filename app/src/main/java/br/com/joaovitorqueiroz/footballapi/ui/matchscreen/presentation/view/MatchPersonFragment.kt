package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.databinding.FragmentMatchPersonBinding
import br.com.joaovitorqueiroz.footballapi.domain.mapper.toMatch
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Match
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.viewmodel.MatchViewModel
import br.com.joaovitorqueiroz.footballapi.ui.team.presentation.adapter.TeamSquadAdapter
import br.com.joaovitorqueiroz.footballapi.ui.team.presentation.viewmodel.TeamViewModel
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.snackbar
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.toast
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MatchPersonFragment : Fragment() {
    private lateinit var _binding: FragmentMatchPersonBinding
    private val matchViewModel: MatchViewModel by activityViewModels()
    private val teamViewModel: TeamViewModel by viewModels()
    private lateinit var teamSquadAdapter: TeamSquadAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMatchPersonBinding.inflate(inflater, container, false)
        _binding.viewModel = teamViewModel
        _binding.lifecycleOwner = viewLifecycleOwner
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initObservers()
        setListeners()
    }

    private fun initAdapter() {
    }

    private fun initObservers() {
        matchViewModel.match.observe(viewLifecycleOwner) {
            it?.let { safeState ->
                when (safeState) {
                    is MatchViewModel.MatchUIState.Error -> {
                        safeState.exception.printStackTrace()
                        snackbar(message = safeState.message)
                    }

                    is MatchViewModel.MatchUIState.Success<MatchResponse?> -> {
                        safeState.data?.toMatch()?.let { safeMatch ->
                            _binding.match = safeMatch
                            teamViewModel.getTeamById(safeMatch.homeTeam.id)
                        }
                    }
                }
            }
        }
        teamViewModel.team.observe(viewLifecycleOwner) { it ->
            it?.let { safeState ->
                when (safeState) {
                    is TeamViewModel.TeamResultState.Error -> {
                        with(safeState.exception) {
                            printStackTrace()
                            message?.let {
                                snackbar(message = R.string.message_error_state_default)
                            }
                        }
                    }

                    is TeamViewModel.TeamResultState.Success -> {
                        with(_binding.rvSquadTeam) {
                            setHasFixedSize(true)
                            adapter = TeamSquadAdapter()
                            teamSquadAdapter = adapter as TeamSquadAdapter
                        }
                        safeState.data?.squad?.let { safeListSquad ->
                            teamSquadAdapter.submitList(safeListSquad)
                            _binding.coach = safeState.data.coach
                        }
                    }
                }
            }
        }
    }

    private fun setListeners() {
        _binding.radioSelectSquad.setOnCheckedChangeListener { radioGroup, _ ->
            when (radioGroup.checkedRadioButtonId) {
                R.id.radio_home_team -> {
                    _binding.match?.homeTeam?.id?.let {
                        teamViewModel.getTeamById(it)
                    }
                }

                R.id.radio_away_team -> {
                    _binding.match?.awayTeam?.id?.let {
                        teamViewModel.getTeamById(it)
                    }
                }
            }
        }
    }
}
