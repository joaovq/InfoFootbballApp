package br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.databinding.FragmentMatchesBinding
import br.com.joaovitorqueiroz.footballapi.domain.mapper.toMapperCompetition
import br.com.joaovitorqueiroz.footballapi.ui.home.presentation.view.HomeFragmentDirections
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.adapter.CompetitionItemAdapter
import br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.viewmodel.MatchesUIState
import br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.viewmodel.MatchesViewModel
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.showProgressDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MatchesFragment : Fragment() {
    private lateinit var _binding: FragmentMatchesBinding
    private val matchesViewModel: MatchesViewModel by viewModels()
    private val customDialogProgressBar: Dialog by lazy {
        Dialog(
            requireContext(),
            androidx.appcompat.R.style.Theme_AppCompat_DayNight_DialogWhenLarge,
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMatchesBinding.inflate(inflater, container, false)

        _binding.viewModel = matchesViewModel
        _binding.lifecycleOwner = viewLifecycleOwner
        _binding.dialog = customDialogProgressBar

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        matchesViewModel.matchList.observe(viewLifecycleOwner) { matchesList ->
            matchesList?.let { safeState ->
                when (safeState) {
                    is MatchesUIState.Error -> {
                        safeState.exception.printStackTrace()
                    }

                    is MatchesUIState.Success<MatchList?> -> {
                        _binding.rvMatchesCompetition.setHasFixedSize(true)
                        safeState.data?.let {
                            _binding.rvMatchesCompetition.adapter =
                                CompetitionItemAdapter(it) { matchId ->
                                    val toMatchFragment =
                                        HomeFragmentDirections.actionHomeFragmentToMatchFragment(
                                            matchId,
                                        )
                                    activity?.findNavController(R.id.main_nav_container)
                                        ?.navigate(toMatchFragment)
                                }
                        }
                        val adapter =
                            _binding.rvMatchesCompetition.adapter as CompetitionItemAdapter
                        adapter.submitList(
                            safeState.data?.matches.toMapperCompetition()?.toList(),
                        )
                    }
                }
            }
        }
        matchesViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) {
                customDialogProgressBar.showProgressDialog()
            } else {
                customDialogProgressBar.dismiss()
            }
        }
    }
}
