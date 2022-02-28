package com.inflames.footballteamwithktor.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.inflames.footballteamwithktor.data.model.FootballTeam
import com.inflames.footballteamwithktor.network.FootballTeamService
import kotlinx.coroutines.launch

class FootballViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>(false)
    val isLoading: LiveData<Boolean> get() = _isLoading


    private val _teamList = MutableLiveData<List<FootballTeam>>(listOf())
    val teamList: LiveData<List<FootballTeam>> get() = _teamList

    init {
        getTeams()
    }

    fun getTeams() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _teamList.value = FootballTeamService.cryptoService.getTeams()
            } catch (e: Exception) {
                _isLoading.value = false
                Log.e("FootbalViewModel", "get FootbalTeam: ", e)
            }
        }
    }

}