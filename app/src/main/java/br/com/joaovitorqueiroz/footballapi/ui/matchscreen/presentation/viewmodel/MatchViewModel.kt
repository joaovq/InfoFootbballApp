package br.com.joaovitorqueiroz.footballapi.ui.matchscreen.presentation.viewmodel

import androidx.annotation.StringRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.joaovitorqueiroz.footballapi.R
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetMatchHead2Head
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetMatchHead2HeadUseCase
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetMatchUseCase
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.Head2HeadResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.data.api.MatchResponse
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Head2Head
import br.com.joaovitorqueiroz.footballapi.ui.matchscreen.domain.model.Match
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchViewModel @Inject constructor(
    private val getMatchUseCase: GetMatchUseCase,
    private val getMatchHead2Head: GetMatchHead2HeadUseCase,
) : ViewModel() {
    private val _match: MutableLiveData<MatchUIState<MatchResponse?>?> = MutableLiveData()
    val match: LiveData<MatchUIState<MatchResponse?>?> = _match
    private val _head2head: MutableLiveData<MatchUIState<Head2HeadResponse?>?> = MutableLiveData()
    val head2head: LiveData<MatchUIState<Head2HeadResponse?>?> = _head2head
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getMatch(matchId: Long) {
        _isLoading.postValue(true)
        viewModelScope.launch {
            try {
                _match.value = MatchUIState.Success(getMatchUseCase(matchId))
                _isLoading.postValue(false)
            } catch (e: Exception) {
                _match.value = MatchUIState.Error(e)
                _isLoading.postValue(false)
            }
        }
    }

    fun getHead2Head(matchId: Long) {
        _isLoading.postValue(true)
        viewModelScope.launch {
            try {
                _head2head.value = MatchUIState.Success(getMatchHead2Head(matchId))
                _isLoading.postValue(false)
            } catch (e: Exception) {
                _head2head.value = MatchUIState.Error(e)
                _isLoading.postValue(false)
            }
        }
    }

    sealed interface MatchUIState<out T> {
        data class Success<T>(val data: T) : MatchUIState<T>
        data class Error(
            val exception: Exception,
            @StringRes val message: Int = R.string.message_error_state_default,
        ) :
            MatchUIState<Nothing>
    }
}
