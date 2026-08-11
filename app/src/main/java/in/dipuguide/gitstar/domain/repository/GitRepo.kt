package `in`.dipuguide.gitstar.domain.repository

import `in`.dipuguide.gitstar.domain.model.Item

interface GitRepo {
    suspend fun fetchGitRepo(
        language: String,
        sort: String,
    ): Result<List<Item>>
}