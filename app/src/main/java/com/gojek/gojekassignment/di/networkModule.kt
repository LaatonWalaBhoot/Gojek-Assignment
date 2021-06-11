package com.gojek.gojekassignment.di

import android.content.Context
import com.gojek.gojekassignment.core.network.ApiService
import com.gojek.gojekassignment.core.network.CacheInterceptor
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by LaatonWalaBhoot on 11/06/21.
 */

val networkModule = module {
    factory { provideCache(get()) }
    factory { provideOkHttpClient(get(), get()) }
    factory { CacheInterceptor(get()) }
    factory { provideMoshi() }
    single { provideRetrofit(get(), get()) }
    factory { provideNetworkApi(get()) }
}

fun provideCache(context: Context): Cache {
    val cacheSize = (10 * 1024 * 1024).toLong()
    return Cache(File(context.cacheDir, "http-cache"), cacheSize)
}

fun provideOkHttpClient(
    cache: Cache,
    cacheInterceptor: CacheInterceptor,
): OkHttpClient {
    return OkHttpClient().newBuilder()
        .cache(cache)
        .connectTimeout(90, TimeUnit.SECONDS)
        .writeTimeout(90, TimeUnit.SECONDS)
        .readTimeout(90, TimeUnit.SECONDS)
        .addInterceptor(cacheInterceptor)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
        .build()

}

fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}

fun provideRetrofit(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
    return Retrofit.Builder()
        .baseUrl("https://run.mocky.io/")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .client(okHttpClient)
        .build()
}

fun provideNetworkApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)