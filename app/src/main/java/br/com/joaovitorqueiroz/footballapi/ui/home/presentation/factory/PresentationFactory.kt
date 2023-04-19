package br.com.joaovitorqueiroz.footballapi.ui.home.presentation.factory

import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.ui.home.domain.model.Presentation

object PresentationFactory {
    fun createPresentation(): List<Presentation> =
        listOf(
            Presentation(
                "It's Boring",
                "Get informations of football are complicated? ",
                R.drawable.person_watching_tv,
            ),
            Presentation(
                "Fast Information",
                "You think have fast information of your team? Rapid news?",
                R.drawable.people_and_technology,
            ),
            Presentation(
                "Your new favorite app",
                "We focus in football category, great quality information.",
                R.drawable.building_surrounded_by_nature,
            ),
        )
}
