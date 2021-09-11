package com.expertsclub.expertspaging3.data.repository

import com.expertsclub.expertspaging3.data.model.Character

interface CharactersRepository {

    fun getCharacters(): List<Character>
}