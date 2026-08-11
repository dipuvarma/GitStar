package `in`.dipuguide.gitstar.data.datasorce.remote.dto

import com.google.gson.annotations.SerializedName

data class ItemDto(
    val id: Int,
    val name: String,
    val description: String,
    val language: String,
    @SerializedName("stargazers_count") val starCount: Int,
)