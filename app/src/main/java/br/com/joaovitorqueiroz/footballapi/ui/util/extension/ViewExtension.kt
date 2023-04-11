package br.com.joaovitorqueiroz.footballapi.ui.util.extension

import android.app.Dialog
import android.content.Context
import android.view.View
import androidx.core.view.isVisible
import br.com.joaovitorqueiroz.footballapi.R

fun View.visible() {
    this.isVisible = true
}

fun View.gone() {
    this.isVisible = false
}

fun Dialog.showProgressDialog(
    context: Context = this.context,
    content: Int = R.layout.custom_dialog_layout,
) {
    this.setContentView(content)
    this.setCancelable(false)
    this.show()
}