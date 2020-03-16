package com.exemple.android.cinephilesapp.repository

import androidx.lifecycle.LiveData
import com.exemple.android.cinephilesapp.model.UpcomingMovie
import com.exemple.android.cinephilesapp.model.UpcomingResults

interface MovieRepository {
    fun getUpcomingMovies(): LiveData<UpcomingResults>
}