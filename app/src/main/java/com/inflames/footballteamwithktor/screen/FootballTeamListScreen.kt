package com.inflames.footballteamwithktor.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.inflames.footballteamwithktor.data.model.FootballTeam
import com.inflames.footballteamwithktor.ui.theme.Typography


@Composable
fun FootballTeamListScreen(
    teams: List<FootballTeam>
) {
    Column {
        if (teams.isEmpty()) {
            Text(text = "Failed while getting data from internet")
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(top = 8.dp)
            ) {
                items(teams) {
                    TeamRow(teamItem = it)
                }
            }
        }
    }
}


@Composable
fun TeamRow(teamItem: FootballTeam) {
    Row(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = rememberImagePainter(
                data = teamItem.imageUrl,
                builder = { crossfade(true) }
            ), contentDescription = teamItem.name + " Football Team's Logo",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )


        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = teamItem.name,
            style = Typography.h6
        )
        Spacer(modifier = Modifier.width(68.dp))

        Text(text = teamItem.coachName, style = Typography.body1)

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTeamRow() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = com.inflames.footballteamwithktor.R.drawable.ic_launcher_background),
            contentDescription = " Football Team's Logo",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = "Fenerbahçe",
            style = Typography.h6 )

        Text(text = "İsmail Kartal", style = Typography.body1)


    }
    
    Spacer(modifier = Modifier.height(24.dp))
}