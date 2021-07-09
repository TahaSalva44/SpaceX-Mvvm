package com.example.galeritutorial.di.module

import android.util.Log
import com.google.gson.Gson
import com.example.galeritutorial.di.qualifiers.BaseUrlQualifier
import com.example.galeritutorial.di.scope.AppScope
import com.example.galeritutorial.network.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

@Module(includes = [AppModule::class])
class NetworkModule {
    @AppScope
    @Provides
    fun provideApiService(okHttpClient: OkHttpClient, gson: Gson, @BaseUrlQualifier baseUrl: String): ApiService {
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
        return retrofitBuilder.build().create(ApiService::class.java)
    }

    @AppScope
    @Provides
    fun provideOkHttpClient(builder: OkHttpClient.Builder): OkHttpClient {
        return builder.build()
    }

    @AppScope
    @Provides
    fun provideOkHttpBuilder(loggingInterceptor: HttpLoggingInterceptor, cookieJar: CookieJar): OkHttpClient.Builder {
        val okHttpBuilder = OkHttpClient.Builder()
        //okHttpBuilder.cookieJar(cookieJar);
        okHttpBuilder.cookieJar(cookieJar)
            .addInterceptor(loggingInterceptor)
            //.certificatePinner(certPinner)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
        return okHttpBuilder

    }

    //region Interceptors

    @AppScope
    @Provides
    fun getHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return loggingInterceptor
    }
    //endregion

    @AppScope
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @AppScope
    @Provides
    fun provideCookieJar(): CookieJar {
        return object : CookieJar {
            val TAG = "Cookie Jar"
            var cookies: List<Cookie> = Collections.emptyList()

            override fun saveFromResponse(url: HttpUrl, cookies: List<Cookie>) {
                for (cookie in cookies) {
                    Log.i(TAG, "cookie: " + cookie.toString())
                }
                this.cookies = cookies
            }

            override fun loadForRequest(url: HttpUrl): List<Cookie> {
                Log.d(TAG, "loadForRequest() called with: url = [$url]")
                return cookies
            }
        }
    }
}