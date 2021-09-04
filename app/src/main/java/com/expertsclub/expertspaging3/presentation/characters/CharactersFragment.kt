package com.expertsclub.expertspaging3.presentation.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.expertsclub.expertspaging3.R
import com.expertsclub.expertspaging3.data.model.Character
import com.expertsclub.expertspaging3.databinding.CharactersFragmentBinding

class CharactersFragment : Fragment() {

    private var _binding: CharactersFragmentBinding? = null
    private val binding get() = _binding!!

    private val charactersAdapter = CharactersAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CharactersFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerCharacters()

        charactersAdapter.submitList(listOf(
            Character(1, "Rick", "Alive", "Human", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            Character(1, "Rick", "Alive", "Human", ""),
            Character(1, "Rick", "Alive", "Human", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            Character(1, "Rick", "Alive", "Human", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            Character(1, "Rick", "Unknown", "Human", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            Character(1, "Rick", "Alive", "Human", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            Character(1, "Rick", "Alive", "Human", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
            Character(1, "Rick", "Alive", "Human", "https://rickandmortyapi.com/api/character/avatar/1.jpeg"),
        ))
    }

    fun setRecyclerCharacters() {
        with(binding.recyclerCharacters) {
            setHasFixedSize(true)
            adapter = charactersAdapter
        }
    }
}