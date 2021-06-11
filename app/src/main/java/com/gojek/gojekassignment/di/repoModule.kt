package com.gojek.gojekassignment.di

import com.gojek.gojekassignment.ui.main.MainRepo
import org.koin.dsl.module

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */

val repoModule = module {
    factory { MainRepo(get()) }
}