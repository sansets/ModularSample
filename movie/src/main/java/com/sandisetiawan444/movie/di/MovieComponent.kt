package com.sandisetiawan444.movie.di

import com.sandisetiawan444.movie.ui.MovieFragment
import com.sandisetiawan444.movie.ui.MovieModule
import dagger.Component

/**
 * Created by Sandi on 30/01/2020.
 */

@Component(modules = [MovieDataModule::class, MovieModule::class])
@MovieScope
interface MovieComponent {

    fun inject(fragment: MovieFragment)
}