package br.com.joaovitorqueiroz.footballapi.ui.matches.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetAllMatchesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchesViewModel @Inject constructor(
    val getAllMatchesUseCase: GetAllMatchesUseCase,
) : ViewModel() {

    private val _matchList: MutableLiveData<MatchesUIState> = MutableLiveData()
    val matchList: LiveData<MatchesUIState> get() = _matchList

    init {
        getAllMatches()
    }

    fun getAllMatches() {
        _matchList.value = MatchesUIState.Loading
        viewModelScope.launch {
            try {
                val matches = getAllMatchesUseCase()
                _matchList.value =
                    MatchesUIState.Success(data = matches)
            } catch (e: Exception) {
                _matchList.value =
                    MatchesUIState.Error(exception = e)
            }
        }
    }
}

sealed interface MatchesUIState {
    data class Success<T>(val data: T, val message: Int = R.string.message_success_state_default) :
        MatchesUIState

    object Loading : MatchesUIState
    data class Error(
        val exception: Exception,
        val message: Int = R.string.message_error_state_default,
    ) : MatchesUIState
}
