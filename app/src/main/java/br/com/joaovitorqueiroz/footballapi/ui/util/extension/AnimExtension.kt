package br.com.joaovitorqueiroz.footballapi.util.extension

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import androidx.annotation.AnimRes
import br.com.joaovitorqueiroz.footballapi.R

fun View.animViewbyId(
    context: Context,
    @AnimRes animId: Int = R.anim.rotate_scale,
    duration: Long = 1000,
) {
    AnimationUtils.loadAnimation(context, animId).also { animation ->
        animation.duration = duration
        this.startAnimation(animation)
    }
}
