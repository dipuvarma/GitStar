package `in`.dipuguide.gitstar.data.repository

import android.util.Log
import `in`.dipuguide.gitstar.data.datasorce.remote.api.GitRepoApiInterface
import `in`.dipuguide.gitstar.data.mapper.toItem
import `in`.dipuguide.gitstar.domain.model.GitItem
import `in`.dipuguide.gitstar.domain.repository.GitRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GitRepoImpl @Inject constructor(
    private val apiInterface: GitRepoApiInterface,
) : GitRepo {
    override suspend fun fetchGitRepo(
        sort: String,
    ): Result<List<GitItem>> = withContext(Dispatchers.IO) {
        try {
            val gitItems = apiInterface.fetchGitRepo(sort = sort)
            Result.success(gitItems.items.map { it.toItem() })
        } catch (e: Exception) {
            Log.d("TAG", "fetchGitRepo: $e")
            Result.failure(e)
        }
    }
}