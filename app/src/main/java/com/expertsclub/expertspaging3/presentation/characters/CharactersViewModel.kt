package com.expertsclub.expertspaging3.presentation.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.expertsclub.expertspaging3.data.repository.CharactersRepository

class CharactersViewModel(
    charactersRepository: CharactersRepository
) : ViewModel() {

    val charactersFlow = charactersRepository.getCharacters()
        .cachedIn(viewModelScope)

    class Factory(
        private val charactersRepository: CharactersRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(CharactersRepository::class.java)
                .newInstance(charactersRepository)
        }
    }
}