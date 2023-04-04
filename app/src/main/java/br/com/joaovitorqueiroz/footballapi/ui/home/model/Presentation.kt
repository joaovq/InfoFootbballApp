package br.com.joaovitorqueiroz.footballapi.ui.home.model

import androidx.annotation.DrawableRes

data class Presentation(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)
