package br.com.joaovitorqueiroz.footballapi.ui.home.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.data.preferences.UserPreferences
import br.com.joaovitorqueiroz.footballapi.databinding.FragmentOnboardingPresentationBinding
import br.com.joaovitorqueiroz.footballapi.ui.home.presentation.adapter.PresentationAdapter
import br.com.joaovitorqueiroz.footballapi.ui.home.presentation.factory.PresentationFactory
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.gone
import br.com.joaovitorqueiroz.footballapi.ui.util.extension.visible
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnboardingPresentationFragment : Fragment() {

    private lateinit var _binding: FragmentOnboardingPresentationBinding

    @Inject
    lateinit var prefs: UserPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentOnboardingPresentationBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewPagerList()
        setListeners()
    }

    private fun setViewPagerList() {
        val adapter = PresentationAdapter()
        _binding.vpItemPresentation.adapter = adapter
        adapter.submitList(PresentationFactory.createPresentation())
        _binding.vpItemPresentation
        TabLayoutMediator(
            _binding.tabLtViewPager,
            _binding.vpItemPresentation,
            true,
            true,
        ) { _, _ ->
        }.attach()
    }

    private fun setListeners() {
        _binding.tabLtViewPager.addOnTabSelectedListener(
            object : TabLayout.OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    when (tab?.position) {
                        _binding.vpItemPresentation.adapter?.itemCount?.dec() -> {
                            _binding.btnGetStarted.visible()
                            _binding.tabLtViewPager.gone()
                            _binding.fabNextButton.gone()
                        }
                        0 -> {
                            _binding.fabBackButton.gone()
                        }
                        else -> {
                            _binding.btnGetStarted.gone()
                            _binding.fabBackButton.visible()
                            _binding.fabNextButton.visible()
                            _binding.tabLtViewPager.visible()
                        }
                    }
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {
                }

                override fun onTabReselected(tab: TabLayout.Tab?) {
                }
            },
        )
        _binding.fabNextButton.setOnClickListener {
            _binding.vpItemPresentation.apply {
                if (currentItem < (adapter?.itemCount?.dec() ?: 2)) {
                    setCurrentItem(currentItem.inc(), true)
                }
            }
        }
        _binding.fabBackButton.setOnClickListener {
            _binding.vpItemPresentation.apply {
                if (currentItem > 0) {
                    setCurrentItem(currentItem.dec(), true)
                }
            }
        }

        _binding.btnGetStarted.setOnClickListener {
            prefs.isNewUser = false
            val action =
                OnboardingPresentationFragmentDirections.actionOnboardingPresentationFragmentToHomeFragment()
            findNavController().navigate(R.id.homeFragment)
        }
    }
}
