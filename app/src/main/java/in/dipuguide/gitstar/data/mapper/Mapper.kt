package `in`.dipuguide.gitstar.data.mapper

import `in`.dipuguide.gitstar.data.datasorce.remote.dto.ItemDto
import `in`.dipuguide.gitstar.domain.model.Item

fun ItemDto.toItem(): Item {
    return Item(
        id = id,
        name = name,
        description = description,
        language = language,
        starCount = starCount
    )
}

fun Item.toItemDto(): ItemDto {
    return ItemDto(
        id = id,
        name = name,
        description = description,
        language = language,
        starCount = starCount
    )
}