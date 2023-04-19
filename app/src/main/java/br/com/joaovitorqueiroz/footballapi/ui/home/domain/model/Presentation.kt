package br.com.joaovitorqueiroz.footballapi.ui.home.domain.model

import androidx.annotation.DrawableRes

data class Presentation(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)
