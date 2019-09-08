package com.mahdan.features.moviedetail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.mahdan.features.moviedetail.databinding.FragmentMovieDetailBinding
import com.mahdan.features.moviedetail.viewmodel.MovieDetailViewModel
import id.mahdan.common.base.BaseFragment
import id.mahdan.common.base.BaseViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MovieDetailFragment : BaseFragment() {

    private val viewModel: MovieDetailViewModel by viewModel()
    private lateinit var binding: FragmentMovieDetailBinding

    private val navArgs: MovieDetailFragmentArgs by navArgs()

    override fun getViewModel(): BaseViewModel = viewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMovieDetailBinding.inflate(inflater, container, false)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.viewmodel?.getMovie(navArgs.id)
    }

}