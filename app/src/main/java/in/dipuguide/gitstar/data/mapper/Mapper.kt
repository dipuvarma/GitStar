package `in`.dipuguide.gitstar.data.mapper

import `in`.dipuguide.gitstar.data.datasorce.remote.dto.Item
import `in`.dipuguide.gitstar.domain.model.GitItem

fun Item.toItem(): GitItem {
    return GitItem(
        id = id,
        name = name,
        description = description,
        language = language,
        starCount = starCount
    )
}