package com.exemple.android.cinephilesapp.model

data class UpcomingResults(val id: Int,
                           val title: String,
                           val poster_path: String,
                           val backdrop_path: String,
                           val genre_ids: List<Int>,
                           val release_date: String)