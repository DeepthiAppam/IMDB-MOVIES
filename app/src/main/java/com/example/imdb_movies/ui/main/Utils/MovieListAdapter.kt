package com.example.imdb_movies.ui.main.Utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb_movies.databinding.MovieListItemViewBinding

class MovieListAdapter(private val list : List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder<ViewHolder>>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = MovieListItemViewBinding.inflate(LayoutInflater.from(viewGroup.context),viewGroup,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        //@todo set appropriate data object so that it bindings using coressponding fields
        viewHolder.bind(list[position])
    }

    override fun getItemCount() = list.size
}
class ViewHolder(private val binding: MovieListItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(data : String){
        binding.data = data
    }
}