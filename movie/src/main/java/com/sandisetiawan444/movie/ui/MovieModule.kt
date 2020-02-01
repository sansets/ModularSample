package com.sandisetiawan444.movie.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sandisetiawan444.base.viewmodel.ViewModelFactory
import com.sandisetiawan444.base.viewmodel.ViewModelKey
import com.sandisetiawan444.movie.di.MovieScope
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Sandi on 30/01/2020.
 */

@Module
abstract class MovieModule {

    @MovieScope
    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @MovieScope
    @Binds
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    internal abstract fun bindViewModel(viewModel: MovieViewModel): ViewModel
}