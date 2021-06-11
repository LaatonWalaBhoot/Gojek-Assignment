package com.gojek.gojekassignment.core.network

import com.gojek.gojekassignment.core.models.Repository
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */

interface ApiService {

    @GET("/v3/7ef86b70-f1a8-40ab-854c-5d679cd51cd4")
    fun getRepositories(
    ): Single<List<Repository>>
}