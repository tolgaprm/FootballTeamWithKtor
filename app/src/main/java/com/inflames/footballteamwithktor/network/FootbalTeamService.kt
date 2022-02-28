package com.inflames.footballteamwithktor.network

import com.inflames.footballteamwithktor.data.model.FootballTeam
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:8080"

interface FootballTeamAPI {

    @GET("/teams")
    suspend fun getTeams(): List<FootballTeam>
}

object FootballTeamService {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val cryptoService = retrofit.create(FootballTeamAPI::class.java)
}