package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import br.com.joaovitorqueiroz.footballapi.databinding.FragmentMatchBinding
import br.com.joaovitorqueiroz.footballapi.domain.mapper.toMatch
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.mappers.toHead2Head
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Match
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.adapter.StatisticsMatchAdapter
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.factory.StatisticsFactory
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.viewmodel.MatchViewModel
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.snackbar
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MatchFragment : Fragment() {
    private lateinit var _binding: FragmentMatchBinding
    private val args: MatchFragmentArgs by navArgs()
    private val matchViewModel: MatchViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMatchBinding.inflate(inflater, container, false)
        _binding.matchViewModel = matchViewModel
        _binding.lifecycleOwner = viewLifecycleOwner
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.apply {
            matchViewModel.getMatch(matchId)
            matchViewModel.getHead2Head(matchId)
        }
        setUpNavigationToolbar()
        initObservers()
    }

    private fun setUpNavigationToolbar() {
        _binding.layoutCollapsingToolbar.toolbarMatch.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
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
                        Timber.tag("data").d("%s", safeState.data.toString())
                        safeState.data?.toMatch()?.let { safeMatch ->
                            _binding.match = safeMatch
                            setUpViewPager(safeMatch)
                        }
                    }
                }
            }
        }
        matchViewModel.head2head.observe(viewLifecycleOwner) {
            it?.let { safeState ->
                when (safeState) {
                    is MatchViewModel.MatchUIState.Error -> {
                        safeState.exception.printStackTrace()
                        snackbar(message = safeState.message)
                    }

                    is MatchViewModel.MatchUIState.Success<Head2HeadResponse?> -> {
                        Timber.tag("data").d("%s", safeState.data.toString())
                        safeState.data?.toHead2Head()?.let { safeHead2Head ->
                            Timber.tag("data mapper:").d("%s", safeHead2Head.toString())
                            _binding.head2Head = safeHead2Head
                        }
                    }
                }
            }
        }
    }

    private fun setUpViewPager(match: Match) {
        _binding.vpContainerMatch.adapter =
            activity?.supportFragmentManager?.let {
                StatisticsMatchAdapter(
                    it,
                    lifecycle,
                    StatisticsFactory.createListFragmentsStatistics(),
                )
            }
        TabLayoutMediator(_binding.tabMatchContents, _binding.vpContainerMatch) { tabs, position ->
            tabs.setIcon(StatisticsFactory.createListFragmentsStatistics()[position].icon)
        }.attach()
    }
}
