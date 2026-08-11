package `in`.dipuguide.gitstar.data.datasorce.remote.api

import `in`.dipuguide.gitstar.data.datasorce.remote.dto.GitItemDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GitRepoApiInterface {

    @GET("search/repositories")
    suspend fun fetchGitRepo(
        @Query("language") language: String,
        @Query("sort") sort: String,
    ): GitItemDto

}