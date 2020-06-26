package com.bulentyarbasi.movies.service

import com.bulentyarbasi.movies.model.Movie
import com.bulentyarbasi.movies.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface TMDbApi {

    @GET("movie/now_playing?api_key=3e94b6df120a99d34bbe709538a13de2")
    fun getNowPlayings(): Call<MovieResponse>

    @GET("movie/top_rated?api_key=3e94b6df120a99d34bbe709538a13de2")
    fun getTopRated(): Call<MovieResponse>

    @GET("movie/upcoming?api_key=3e94b6df120a99d34bbe709538a13de2")
    fun getUpcomings(): Call<MovieResponse>
}