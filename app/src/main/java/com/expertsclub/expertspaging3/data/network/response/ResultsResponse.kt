package com.expertsclub.expertspaging3.data.network.response

import com.expertsclub.expertspaging3.data.model.Character
import com.expertsclub.expertspaging3.data.model.Status
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResultsResponse(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val image: String
)

fun ResultsResponse.toCharacterModel() = Character(
    id = this.id,
    name = this.name,
    status = when (this.status) {
        "Alive" -> Status.Alive
        "Dead" -> Status.Dead
        else -> Status.Unknown
    },
    species = this.species,
    imageUrl = this.image
)
