package br.com.joaovitorqueiroz.footballapi.ui.matches.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetAllMatchesUseCase
import br.com.joaovitorqueiroz.footballapi.ui.matches.data.api.MatchList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    val getAllMatchesUseCase: GetAllMatchesUseCase,
) : ViewModel() {

    private val _matchList: MutableLiveData<MatchesUIState<MatchList?>?> = MutableLiveData()
    val matchList: LiveData<MatchesUIState<MatchList?>?> get() = _matchList
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    init {
        getAllMatches()
    }

    fun getAllMatches() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val matches = getAllMatchesUseCase()
                _matchList.value =
                    MatchesUIState.Success(data = matches)
                _isLoading.value = false
            } catch (e: Exception) {
                _matchList.value =
                    MatchesUIState.Error(exception = e)
                _isLoading.value = false
            }
        }
    }
}

sealed interface MatchesUIState<out T> {
    data class Success<T>(val data: T, val message: Int = R.string.message_success_state_default) :
        MatchesUIState<T>

    data class Error(
        val exception: Exception,
        val message: Int = R.string.message_error_state_default,
    ) : MatchesUIState<Nothing>
}
