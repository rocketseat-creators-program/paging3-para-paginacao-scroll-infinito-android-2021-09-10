package com.expertsclub.expertspaging3.presentation.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.expertsclub.expertspaging3.data.repository.CharactersRepository

class CharactersViewModel(
    charactersRepository: CharactersRepository
) : ViewModel() {

    val characters = liveData {
        emit(charactersRepository.getCharacters())
    }

    class Factory(
        private val charactersRepository: CharactersRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(CharactersRepository::class.java)
                .newInstance(charactersRepository)
        }
    }
}