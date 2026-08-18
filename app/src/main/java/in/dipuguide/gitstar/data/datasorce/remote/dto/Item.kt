package `in`.dipuguide.gitstar.data.datasorce.remote.dto

import com.google.gson.annotations.SerializedName

data class Item(
    val description: String,
    val id: Int,
    val language: String,
    val name: String,
    @SerializedName("stargazers_count") val starCount: Int,
)