package `in`.dipuguide.gitstar.domain.repository

import `in`.dipuguide.gitstar.domain.model.GitItem

interface FetchGitRepo {
    suspend fun fetchGitRepo(
        language: String,
        sort: String,
    ): Result<List<GitItem>>
}