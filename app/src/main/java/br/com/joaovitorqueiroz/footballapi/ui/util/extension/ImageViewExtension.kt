package br.com.joaovitorqueiroz.footballapi.ui.util.extension

import android.content.Context
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.core.net.toUri
import br.com.joaovitorqueiroz.footballapi.R
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import com.bumptech.glide.Glide

fun ImageView.loadImage(
    context: Context = this.context,
    url: String,
    @DrawableRes error: Int = R.drawable.ic_error_default_image,
) {
    val imageLoader = ImageLoader.Builder(this.context)
        .components {
            SvgDecoder.Factory()
        }
        .build()

    if (url.contains("svg")) {
        this.load(url) {
            decoderFactory { result, options, _ -> SvgDecoder(result.source, options) }
        }
    } else {
        val request = ImageRequest.Builder(this.context)
            .crossfade(true)
            .crossfade(500)
            /*.placeholder(R.drawable.placeholder)*/
            .error(R.drawable.ic_error_default_image)
            .data(url)
            .target(this)
            .build()

        imageLoader.enqueue(request)
    }
}
