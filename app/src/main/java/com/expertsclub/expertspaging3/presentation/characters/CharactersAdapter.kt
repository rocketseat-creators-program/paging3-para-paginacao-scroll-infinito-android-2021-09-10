package com.expertsclub.expertspaging3.presentation.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.expertsclub.expertspaging3.R
import com.expertsclub.expertspaging3.data.model.Character
import com.expertsclub.expertspaging3.databinding.ItemCharacterBinding

class CharactersAdapter
    : PagingDataAdapter<Character, CharactersAdapter.CharactersViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        return CharactersViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        getItem(position)?.let { character ->
            holder.bind(character)
        }
    }

    class CharactersViewHolder(
        private val binding: ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character) {
            binding.run {
                Glide.with(itemView)
                    .load(character.imageUrl)
                    .placeholder(R.drawable.photo_loading)
                    .fallback(R.drawable.broken_image)
                    .circleCrop()
                    .into(imageCharacter)

                val status = character.status

                textName.text = character.name
                textStatus.text = itemView.context.getString(status.description)

                val statusImage = status.imageResId

                textStatus.setCompoundDrawablesWithIntrinsicBounds(
                    0,
                    0,
                    statusImage,
                    0
                )

                textSpecies.text = character.species
            }
        }

        companion object {
            fun create(parent: ViewGroup): CharactersViewHolder {
                val itemBinding = ItemCharacterBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)

                return CharactersViewHolder(itemBinding)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Character, newItem: Character) =
                oldItem == newItem

        }
    }
}