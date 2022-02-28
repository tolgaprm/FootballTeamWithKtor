package com.inflames.footballteamwithktor

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.inflames.footballteamwithktor.data.model.FootballTeam
import com.inflames.footballteamwithktor.screen.FootballTeamListScreen
import com.inflames.footballteamwithktor.ui.theme.FootballTeamWithKtorTheme
import com.inflames.footballteamwithktor.viewmodel.FootballViewModel

class MainActivity : ComponentActivity() {

    val footballViewModel by viewModels<FootballViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FootballTeamWithKtorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    FootballListActivity(footballViewModel = footballViewModel)
                }
            }
        }
    }
}

@Composable
fun FootballListActivity(footballViewModel: FootballViewModel) {

    val teamList: List<FootballTeam> by footballViewModel.teamList.observeAsState(listOf())

    FootballTeamListScreen(teams = teamList)

}

