package com.bulentyarbasi.movies.model

import com.google.gson.annotations.SerializedName


data class Movie(
    val id: Int,
    val title: String,
    @SerializedName("adult") val isAdult: Boolean,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("release_date") val releaseDate: String,
    val overview: String,
    @SerializedName("vote_average") val vote: Double,
    @SerializedName("popularity") val popularity: Double
) {
}