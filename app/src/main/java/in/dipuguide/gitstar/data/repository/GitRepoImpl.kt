package `in`.dipuguide.gitstar.data.repository

import android.util.Log
import `in`.dipuguide.gitstar.data.datasorce.remote.api.GitRepoApiInterface
import `in`.dipuguide.gitstar.data.mapper.toItem
import `in`.dipuguide.gitstar.domain.model.GitItem
import `in`.dipuguide.gitstar.domain.repository.GitRepo
import javax.inject.Inject

class GitRepoImpl @Inject constructor(
    private val apiInterface: GitRepoApiInterface,
) : GitRepo {
    override suspend fun fetchGitRepo(
        sort: String,
    ): Result<List<GitItem>> {
        return try {
            val response = apiInterface.fetchGitRepo(sort)
            if (response.isSuccessful) {
                val body = response.body()
                if (body == null || body.items.isEmpty()) {
                    Result.success(emptyList())
                } else {
                    val gitItem = body.items.map { it.toItem() }
                    Log.d("TAG", "fetchGitRepo: $gitItem")
                    Result.success(gitItem)
                }
            } else {
                val errorMessage = codeToErrorMessage(response.code())
                Result.failure(Exception(errorMessage))
            }
        } catch (e: Exception) {
            Log.d("TAG", "fetchGitRepo: $e")
            Result.failure(e)
        }
    }
}

private fun codeToErrorMessage(responseCode: Int): String {
    val message = when (responseCode) {
        400 -> "Bad Request"
        401 -> "Unauthorized"
        404 -> "Not Meal Found"
        500 -> "Server Error"
        else -> "HTTP $responseCode: Unknown Error"
    }
    return message
}