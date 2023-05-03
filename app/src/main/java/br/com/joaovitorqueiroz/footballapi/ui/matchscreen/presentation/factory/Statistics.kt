package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.factory

import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment

data class Statistics(
    val fragment: Fragment,
    @DrawableRes val icon: Int,
)
