package id.mahdan.home.di

import id.mahdan.home.domain.SearchMoviesUseCase
import id.mahdan.home.viewmodel.HomeViewModel
import id.mahdan.home.viewmodel.ImageDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val featureHomeModule = module {
    factory { SearchMoviesUseCase(get()) }
    viewModel { HomeViewModel(get(),get()) }
    viewModel { ImageDetailViewModel() }
}