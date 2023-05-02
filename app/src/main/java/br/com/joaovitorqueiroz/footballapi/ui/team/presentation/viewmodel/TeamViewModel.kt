package br.com.joaovitorqueiroz.footballapi.ui.team.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.joaovitorqueiroz.footballapi.domain.usecases.GetTeamByIdUseCase
import br.com.joaovitorqueiroz.footballapi.ui.team.domain.model.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getTeamByIdUseCase: GetTeamByIdUseCase,
) : ViewModel() {

    private val _team: MutableLiveData<TeamResultState<Team?>> = MutableLiveData()
    val team: LiveData<TeamResultState<Team?>> = _team
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getTeamById(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.postValue(true)
            try {
                _team.postValue(
                    TeamResultState.Success(getTeamByIdUseCase(id)),
                )
            } catch (e: Exception) {
                _team.postValue(
                    TeamResultState.Error(e),
                )
            } finally {
                _isLoading.postValue(false)
            }
        }
    }

    sealed interface TeamResultState<out T> {
        data class Success<T>(val data: T) : TeamResultState<T>
        data class Error(val exception: Exception) : TeamResultState<Nothing>
    }
}
