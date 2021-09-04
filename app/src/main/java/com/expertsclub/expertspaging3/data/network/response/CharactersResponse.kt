package com.expertsclub.expertspaging3.data.network.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharactersResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)