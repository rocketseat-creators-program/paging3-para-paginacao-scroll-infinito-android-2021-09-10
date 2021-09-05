package com.expertsclub.expertspaging3.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.expertsclub.expertspaging3.data.model.Character
import com.expertsclub.expertspaging3.data.network.RickMortyApi
import kotlinx.coroutines.flow.Flow

class CharactersRepositoryImpl(
    private val apiService: RickMortyApi
) : CharactersRepository {

    override fun getCharacters(): Flow<PagingData<Character>> {
        return Pager(config = PagingConfig(pageSize = PAGE_SIZE)) {
            CharactersPagingSource(apiService)
        }.flow
    }

    companion object {
        private const val PAGE_SIZE = 20
    }
}