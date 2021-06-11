package com.gojek.gojekassignment.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.gojek.gojekassignment.core.models.Repository
import io.reactivex.schedulers.Schedulers

class MainViewModel(mainRepo: MainRepo) : ViewModel() {


    val repositories: LiveData<List<Repository>> = LiveDataReactiveStreams
        .fromPublisher(mainRepo.getRepositories()
            .toFlowable()
            .subscribeOn(Schedulers.io()))
}