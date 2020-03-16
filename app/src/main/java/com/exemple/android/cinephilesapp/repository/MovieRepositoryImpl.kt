package com.exemple.android.cinephilesapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exemple.android.cinephilesapp.model.UpcomingMovie
import com.exemple.android.cinephilesapp.model.UpcomingResults
import com.exemple.android.cinephilesapp.repository.retrofit.HttpService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepositoryImpl(private val service: HttpService) : MovieRepository {

    override fun getUpcomingMovies(): LiveData<List<UpcomingMovie>> {

        val data = MutableLiveData<List<UpcomingMovie>>()

        service.upcomingMovies().enqueue(object : Callback<UpcomingResults> {

            override fun onResponse(call: Call<UpcomingResults>, response: Response<UpcomingResults>) {

                data.value = response.body()?.results

            }

            override fun onFailure(call: Call<UpcomingResults>, t: Throwable) {

                Log.e("FLMWG", "Error callback")

            }
        })

        return data
    }

}