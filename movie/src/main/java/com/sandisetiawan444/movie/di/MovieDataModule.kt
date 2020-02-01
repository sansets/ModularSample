package com.sandisetiawan444.movie.di

import com.sandisetiawan444.movie.data.MovieRepository
import com.sandisetiawan444.movie.data.MovieRepositoryImpl
import com.sandisetiawan444.movie.data.remote.MovieRemoteDataSource
import com.sandisetiawan444.movie.data.remote.MovieService
import com.sandisetiawan444.network.ApiFactory.createService
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Dispatchers

/**
 * Created by Sandi on 30/01/2020.
 */

@Module
class MovieDataModule {

    @MovieScope
    @Provides
    fun provideService(): MovieService {
        return createService(MovieService::class.java)
    }

    @MovieScope
    @Provides
    fun provideRemoteDataSource(@MovieScope service: MovieService): MovieRemoteDataSource {
        return MovieRemoteDataSource(service)
    }

    @MovieScope
    @Provides
    fun provideRepository(@MovieScope remoteDataSource: MovieRemoteDataSource): MovieRepository {
        return MovieRepositoryImpl(remoteDataSource)
    }

    @MovieScope
    @Provides
    fun provideSchedulerProvider() = Dispatchers.Main
}