package com.expertsclub.expertspaging3.data.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import okhttp3.OkHttpClient

import okhttp3.logging.HttpLoggingInterceptor


interface RickMortyApi {

    @GET("character")
    suspend fun getCharacters()
}

object RetrofitService {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private fun retrofitService(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .client(getLoggingInterceptor())
            .baseUrl(BASE_URL)
            .build()
    }

    private fun getLoggingInterceptor(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    val rickMortyApi: RickMortyApi by lazy {
        retrofitService().create(RickMortyApi::class.java)
    }

}