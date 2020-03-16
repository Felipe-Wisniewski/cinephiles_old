package com.exemple.android.cinephilesapp.repository.retrofit

import com.exemple.android.cinephilesapp.model.UpcomingResults
import retrofit2.Call
import retrofit2.http.GET

interface HttpService {

    @GET("/movie/upcoming")
    fun upcomingMovies() : Call<UpcomingResults>

}