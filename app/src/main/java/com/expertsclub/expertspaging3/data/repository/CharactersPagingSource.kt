package com.expertsclub.expertspaging3.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.expertsclub.expertspaging3.data.model.Character
import com.expertsclub.expertspaging3.data.network.RickMortyApi
import com.expertsclub.expertspaging3.data.network.response.toCharacterModel
import java.lang.Exception

class CharactersPagingSource(
    private val apiService: RickMortyApi
) : PagingSource<Int, Character>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Character> {
        return try {
            val pageNumber = params.key ?: 1
            val response = apiService.getCharacters(pageNumber)

            LoadResult.Page(
                data = response.results.map { it.toCharacterModel() },
                prevKey = null,
                nextKey = response.info.next.getPageNumber()
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Character>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    private fun String?.getPageNumber(): Int? {
        return this?.split("?page=")?.get(1)?.toInt()
    }
}