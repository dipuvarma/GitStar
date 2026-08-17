package `in`.dipuguide.gitstar.data.repository

import `in`.dipuguide.gitstar.data.datasorce.remote.api.GitRepoApiInterface
import `in`.dipuguide.gitstar.data.mapper.toItem
import `in`.dipuguide.gitstar.domain.model.Item
import `in`.dipuguide.gitstar.domain.repository.GitRepo
import javax.inject.Inject

class GitRepoImpl @Inject constructor(
    private val apiInterface: GitRepoApiInterface,
) : GitRepo {
    override suspend fun fetchGitRepo(
        language: String,
        sort: String,
    ): Result<List<Item>> {
        return try {
            val gitItems = apiInterface.fetchGitRepo(language, sort)
            Result.success(gitItems.items.map { it.toItem() })
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}