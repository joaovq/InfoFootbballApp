package br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.view

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.joaovitorqueiroz.footballapi.databinding.FragmentMatchesBinding
import br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.viewmodel.MatchesViewModel
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
    }
}
