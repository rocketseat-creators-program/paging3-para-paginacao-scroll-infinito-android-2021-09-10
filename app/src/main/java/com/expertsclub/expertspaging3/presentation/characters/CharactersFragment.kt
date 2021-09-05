package com.expertsclub.expertspaging3.presentation.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.expertsclub.expertspaging3.R
import com.expertsclub.expertspaging3.data.model.Character
import com.expertsclub.expertspaging3.data.network.RetrofitService
import com.expertsclub.expertspaging3.data.network.RickMortyApi
import com.expertsclub.expertspaging3.data.repository.CharactersRepositoryImpl
import com.expertsclub.expertspaging3.databinding.CharactersFragmentBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CharactersFragment : Fragment() {

    private var _binding: CharactersFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModelFactory = CharactersViewModel.Factory(
        CharactersRepositoryImpl(RetrofitService.rickMortyApi)
    )

    private lateinit var viewModel: CharactersViewModel

    private val charactersAdapter = CharactersAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(CharactersViewModel::class.java)
    }

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
        loadCharacters()
    }

    private fun setRecyclerCharacters() {
        with(binding.recyclerCharacters) {
            setHasFixedSize(true)
            adapter = charactersAdapter
        }
    }

    private fun loadCharacters() {
        lifecycleScope.launch {
            viewModel.charactersFlow.collectLatest { pagingData ->
                charactersAdapter.submitData(pagingData)
            }
        }
    }
}