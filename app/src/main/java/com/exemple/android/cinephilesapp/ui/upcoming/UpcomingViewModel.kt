package com.exemple.android.cinephilesapp.ui.upcoming

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.exemple.android.cinephilesapp.model.UpcomingMovie
import com.exemple.android.cinephilesapp.repository.MovieRepositoryImpl

class UpcomingViewModel(repository: MovieRepositoryImpl) : ViewModel() {

    val movies : LiveData<List<UpcomingMovie>> = repository.getUpcomingMovies()

}