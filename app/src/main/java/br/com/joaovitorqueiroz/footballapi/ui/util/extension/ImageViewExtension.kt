package br.com.joaovitorqueiroz.footballapi.ui.util.extension

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.net.toUri
import br.com.joaovitorqueiroz.footballapi.R
import com.bumptech.glide.Glide

fun ImageView.loadImage(
    context: Context = this.context,
    url: String,
    @DrawableRes error: Int = R.drawable.ic_error_default_image,
) = Glide.with(context)
    .load(url.toUri())
    .error(error)
    .into(this)
