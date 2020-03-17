package com.exemple.android.cinephilesapp.ui.upcoming.list

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.exemple.android.cinephilesapp.R
import com.exemple.android.cinephilesapp.model.UpcomingMovie
import com.exemple.android.cinephilesapp.ui.upcoming.UpcomingViewModel
import kotlinx.android.synthetic.main.fragment_upcoming_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class UpcomingWebListFragment : Fragment() {

    private val viewModel: UpcomingViewModel by viewModel()

    private val listMovies = mutableListOf<UpcomingMovie>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_upcoming_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        loadMovies()

        viewModel.movies.observe(viewLifecycleOwner, Observer { m ->
            listMovies.addAll(m)
            updateList()
        })
    }

    private fun setupAdapter() {
        rvUpcomingMovie.run {
            val orientation = resources.configuration.orientation

            layoutManager = if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                LinearLayoutManager(activity)

            } else {
                GridLayoutManager(activity, 2)
            }

            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))

            itemAnimator = DefaultItemAnimator()
        }
    }

    private fun loadMovies() {

    }

    private fun updateList() {
        rvUpcomingMovie.adapter = UpcomingAdapter(listMovies, this::onItemClick)
    }

    private fun onItemClick(movie: UpcomingMovie) {
        Log.d("FLMWG", "movie title - ${movie.title}")
    }
}