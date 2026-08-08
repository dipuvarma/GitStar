package `in`.dipuguide.gitstar.domain.model

data class GitItem(
    val id: Int,
    val name: String,
    val description: String,
    val language: String,
    val starCount: Int,
)
