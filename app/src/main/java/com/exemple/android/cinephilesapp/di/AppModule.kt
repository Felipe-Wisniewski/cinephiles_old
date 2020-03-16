package com.exemple.android.cinephilesapp.di

import com.exemple.android.cinephilesapp.repository.MovieRepositoryImpl
import com.exemple.android.cinephilesapp.repository.retrofit.HttpServiceImpl
import com.exemple.android.cinephilesapp.ui.upcoming.UpcomingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        val retrofit = HttpServiceImpl.getService()
        MovieRepositoryImpl(service = retrofit)
    }

    viewModel {
        UpcomingViewModel(repository = get())
    }
}