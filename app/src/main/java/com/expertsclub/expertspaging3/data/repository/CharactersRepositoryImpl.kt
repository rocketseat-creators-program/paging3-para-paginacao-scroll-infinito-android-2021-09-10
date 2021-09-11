package com.expertsclub.expertspaging3.data.repository

import com.expertsclub.expertspaging3.data.model.Character
import com.expertsclub.expertspaging3.data.model.Status
import com.expertsclub.expertspaging3.data.network.RickMortyApi

class CharactersRepositoryImpl(
    private val apiService: RickMortyApi
) : CharactersRepository {

    override fun getCharacters(): List<Character> {
        val characters = mutableListOf<Character>()
        for (i in 0..19) {
            characters.add(
                Character(i, "Character $i", Status.Alive, "Human", "")
            )
        }

        return characters
    }
}