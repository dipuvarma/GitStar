package `in`.dipuguide.gitstar.domain.repository

import `in`.dipuguide.gitstar.domain.model.GitItem

interface GitRepo {
    suspend fun fetchGitRepo(
        sort: String,
    ): Result<List<GitItem>>
}