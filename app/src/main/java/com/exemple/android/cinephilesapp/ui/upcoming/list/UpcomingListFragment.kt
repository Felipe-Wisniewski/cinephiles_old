package com.exemple.android.cinephilesapp.ui.upcoming.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.exemple.android.cinephilesapp.R
import com.exemple.android.cinephilesapp.ui.upcoming.UpcomingViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class UpcomingListFragment : Fragment() {

    private val viewModel: UpcomingViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_upcoming_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    private fun updateList() {

    }
}