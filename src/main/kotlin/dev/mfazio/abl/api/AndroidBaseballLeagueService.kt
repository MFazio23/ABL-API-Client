package dev.mfazio.abl.api

import retrofit2.http.GET

interface AndroidBaseballLeagueService {

    @GET("teams")
    suspend fun getTeams()

    @GET("standings")
    suspend fun getStandings()

    @GET("stats/batting")
    suspend fun getBattingStats()

    @GET("stats/pitching")
    suspend fun getPitchingStats()

}