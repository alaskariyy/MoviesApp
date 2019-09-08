package com.mahdan.features.moviedetail.di

import com.mahdan.features.moviedetail.domain.GetMovieUseCase
import com.mahdan.features.moviedetail.viewmodel.MovieDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureMovieDetailModule = module {
    factory { GetMovieUseCase(get()) }
    viewModel { MovieDetailViewModel(get(),get()) }
}