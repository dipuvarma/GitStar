package `in`.dipuguide.gitstar.data.datasorce.remote.api

import `in`.dipuguide.gitstar.data.datasorce.remote.dto.GitItemDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GitApiInterface {

    @GET("search/repositories")
    suspend fun fetchGitItem(
        @Query("language") language: String,
        @Query("sort") sort: String,
    ): Response<GitItemDto>

}