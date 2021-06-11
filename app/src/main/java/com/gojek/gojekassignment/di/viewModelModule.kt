package com.gojek.gojekassignment.di

import com.gojek.gojekassignment.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
}