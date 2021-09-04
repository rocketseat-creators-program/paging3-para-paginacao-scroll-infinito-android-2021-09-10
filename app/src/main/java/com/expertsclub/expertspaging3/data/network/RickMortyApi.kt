package com.expertsclub.expertspaging3.data.network

import com.expertsclub.expertspaging3.data.network.response.CharactersResponse
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface RickMortyApi {

    @GET("character")
    suspend fun getCharacters(): List<CharactersResponse>
}

object RetrofitService {
    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private fun retrofitService(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }

    val rickMortyApi: RickMortyApi by lazy {
        retrofitService().create(RickMortyApi::class.java)
    }

}