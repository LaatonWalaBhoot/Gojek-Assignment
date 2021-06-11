package com.gojek.gojekassignment.ui.main

import com.gojek.gojekassignment.core.network.ApiService

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */
class MainRepo(private val apiService: ApiService) {
    fun getRepositories() = apiService.getRepositories()
}