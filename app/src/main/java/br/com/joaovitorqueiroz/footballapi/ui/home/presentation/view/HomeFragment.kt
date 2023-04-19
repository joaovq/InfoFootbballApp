package br.com.joaovitorqueiroz.footballapi.ui.home.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import br.com.joaovitorqueiroz.footballapi.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configNavigationComponent()
    }

    private fun configNavigationComponent() {
        val navHostFragment =
            childFragmentManager.findFragmentById(_binding.containerNavigationMain.id)
                as NavHostFragment
        _binding.bottomNavigation.setupWithNavController(navHostFragment.navController)
        val appBarConfiguration = AppBarConfiguration(navHostFragment.navController.graph)
        _binding.toolbarHome.root.setupWithNavController(
            navController = navHostFragment.navController,
            appBarConfiguration,
        )
    }
}
