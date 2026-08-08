package `in`.dipuguide.gitstar.data.repository

import `in`.dipuguide.gitstar.data.datasorce.remote.api.GitApiInterface
import `in`.dipuguide.gitstar.domain.model.GitItem
import `in`.dipuguide.gitstar.domain.repository.FetchGitRepo

class FetchGitRepoImpl(
    private val apiInterface: GitApiInterface,
): FetchGitRepo {
    override suspend fun fetchGitRepo(
        language: String,
        sort: String,
    ): Result<List<GitItem>> {
        TODO("Not yet implemented")
    }

}