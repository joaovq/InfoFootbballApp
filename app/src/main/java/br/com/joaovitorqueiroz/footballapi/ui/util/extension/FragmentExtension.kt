package br.com.joaovitorqueiroz.footballapi.ui.util.extension

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.joaovitorqueiroz.footballapi.R
import com.google.android.material.snackbar.Snackbar

fun Fragment.toast(
    context: Context = this.requireContext(),
    message: Int,
    length: Int = Toast.LENGTH_SHORT,
) {
    Toast.makeText(context, message, length).show()
}

fun Fragment.snackbar(
    view: View = this.requireView(),
    message: Int,
    length: Int = Snackbar.LENGTH_SHORT,
    anchor: Int? = null,
) {
    val snackbar = Snackbar.make(view, message, length)
    anchor?.let {
        snackbar.setAnchorView(R.id.bottom_navigation)
    }
    snackbar.show()
}
