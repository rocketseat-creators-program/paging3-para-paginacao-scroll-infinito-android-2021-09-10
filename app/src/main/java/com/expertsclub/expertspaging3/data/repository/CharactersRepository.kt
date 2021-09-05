package com.expertsclub.expertspaging3.data.repository

import androidx.paging.PagingData
import com.expertsclub.expertspaging3.data.model.Character
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    fun getCharacters(): Flow<PagingData<Character>>
}