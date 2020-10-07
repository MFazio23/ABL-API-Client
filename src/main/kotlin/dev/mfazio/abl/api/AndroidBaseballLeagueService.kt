package dev.mfazio.abl.api

import dev.mfazio.abl.api.models.*
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.time.LocalDate
import java.time.LocalDateTime

interface AndroidBaseballLeagueService {

    @GET("teams")
    suspend fun getTeams(): List<TeamApiModel>

    @GET("games")
    suspend fun getGames(
        @Query("currentDateTime") currentDateTime: LocalDateTime? = null,
        @Query("requestedDate") requestedDate: LocalDate? = null,
        @Query("teamId") teamId: String? = null
    ): List<ScheduledGameApiModel>

    @GET("players")
    suspend fun getPlayers(
        @Query("pageNumber") pageNumber: Int? = null,
        @Query("pageSize") pageSize: Int? = null,
        @Query("teamId") teamId: String? = null,
        @Query("position") position: PositionApiModel? = null,
        @Query("isPitcher") isPitcher: Boolean? = null,
        @Query("isOutfielder") isOutfielder: Boolean? = null
    ): List<PlayerApiModel>

    //TODO: Change this to a PlayerWithStatsApiModel with batting/pitching stats, but null if not applicable
    @GET("players/{playerId}")
    suspend fun getSinglePlayer(
        @Path("playerId") playerId: String,
        @Query("filterDate") filterDate: LocalDate? = null
    ): PlayerApiModel

    @GET("standings")
    suspend fun getStandings(@Query("filterDate") filterDate: LocalDate? = null): List<TeamStandingApiModel>

    @GET("stats/batting")
    suspend fun getBattingStats(
        @Query("date") date: LocalDate? = LocalDate.now(),
        @Query("pageNumber") pageNumber: Int? = null,
        @Query("pageSize") pageSize: Int? = null,
        @Query("sortStat") sortStat: String? = null,
        @Query("sortDescending") sortDescending: Boolean? = null,
        @Query("teamId") teamId: String? = null,
        @Query("position") position: PositionApiModel? = null
    ): List<BatterBoxScoreItemApiModel>

    @GET("stats/pitching")
    suspend fun getPitchingStats(
        @Query("date") date: LocalDate? = LocalDate.now(),
        @Query("pageNumber") pageNumber: Int? = null,
        @Query("pageSize") pageSize: Int? = null,
        @Query("sortStat") sortStat: String? = null,
        @Query("sortDescending") sortDescending: Boolean? = null,
        @Query("teamId") teamId: String? = null,
        @Query("position") position: PositionApiModel? = null
    ): List<PitcherBoxScoreItemApiModel>
}