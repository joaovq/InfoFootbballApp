package br.com.joaovitorqueiroz.footballapi.data.preferences

import android.content.Context
import androidx.core.content.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class UserPreferences @Inject constructor(
    @ApplicationContext context: Context
) {

    private val sharedPreferences =
        context.getSharedPreferences(USER_PREFERENCES_NAME, Context.MODE_PRIVATE)

    var isNewUser: Boolean
        get() = sharedPreferences.getBoolean(IS_NEW_USER_PREFERENCE, true)
        set(value) {
            sharedPreferences.edit {
                putBoolean(IS_NEW_USER_PREFERENCE, value)
            }
        }

    companion object {
        const val USER_PREFERENCES_NAME = "user preferences"
        const val IS_NEW_USER_PREFERENCE = "is_new_user"
    }
}
