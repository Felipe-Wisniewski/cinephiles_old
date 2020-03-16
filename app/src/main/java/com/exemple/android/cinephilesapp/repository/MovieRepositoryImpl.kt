package com.exemple.android.cinephilesapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.exemple.android.cinephilesapp.model.UpcomingResults
import com.exemple.android.cinephilesapp.repository.retrofit.HttpService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepositoryImpl(private val service: HttpService) : MovieRepository {

    override fun getUpcomingMovies(): LiveData<List<UpcomingResults>> {

        val data = MutableLiveData<List<UpcomingResults>>()

        service.upcomingMovies().enqueue(object : Callback<List<UpcomingResults>> {

            override fun onResponse(call: Call<List<UpcomingResults>>, response: Response<List<UpcomingResults>>) {

                data.value = response.body()

            }

            override fun onFailure(call: Call<List<UpcomingResults>>, t: Throwable) {

                Log.e("FLMWG", "Error callback")
                
            }
        })

        return data
    }

}