package com.example.imdb_movies.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.imdb_movies.R
import com.example.imdb_movies.databinding.MovieListFragmentBinding
import com.example.imdb_movies.ui.main.Utils.MovieListAdapter

class MovieListFragment : Fragment() {

    companion object {
        fun newInstance() = MovieListFragment()
    }

    private lateinit var viewModel: MovieListViewModel
    private lateinit var binding : MovieListFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.movie_list_fragment,container,false)
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
    }

    private fun initListeners(){
        viewModel.movieList.observe(viewLifecycleOwner, Observer{
            it?.let {
                binding.rvMovieList.adapter = MovieListAdapter(it)
            }
        })
    }

}