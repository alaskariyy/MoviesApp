package id.mahdan.repository.di

import org.koin.dsl.module
import id.mahdan.repository.AppDispatchers
import id.mahdan.repository.MovieRepository
import id.mahdan.repository.MovieRepositoryImpl
import kotlinx.coroutines.Dispatchers

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { MovieRepositoryImpl(get(), get()) as MovieRepository }
}