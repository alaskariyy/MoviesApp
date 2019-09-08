package id.mahdan.moviesapp.di

import com.mahdan.features.moviedetail.di.featureMovieDetailModule
import id.mahdan.home.di.featureHomeModule
import id.mahdan.local.di.localModule
import id.mahdan.moviesapp.BuildConfig
import id.mahdan.remote.di.remoteModule
import id.mahdan.repository.di.repositoryModule
import org.koin.core.module.Module

/**
 *  List all of module used by root app here
 */

val appComponent :List<Module> = listOf(
    remoteModule(BuildConfig.BASE_URL),
    localModule,
    repositoryModule,
    featureHomeModule,
    featureMovieDetailModule
)