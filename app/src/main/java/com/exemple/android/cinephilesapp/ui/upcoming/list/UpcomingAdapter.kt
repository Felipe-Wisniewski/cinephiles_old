package com.exemple.android.cinephilesapp.ui.upcoming.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.exemple.android.cinephilesapp.R
import com.exemple.android.cinephilesapp.databinding.UpcomingItemBinding
import com.exemple.android.cinephilesapp.model.UpcomingMovie

class UpcomingListAdapter(private val movies: List<UpcomingMovie>,
                          private val onItemClick: (UpcomingMovie) -> Unit) : RecyclerView.Adapter<UpcomingListAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcoming_item, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.binding?.run {
            val currentMovie = movies[position]
            movie = currentMovie

            root.setOnClickListener {
                onItemClick(currentMovie)
            }

            executePendingBindings()
        }
    }

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<UpcomingItemBinding>(view)
    }
}