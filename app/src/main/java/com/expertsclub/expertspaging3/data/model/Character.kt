package com.expertsclub.expertspaging3.data.model

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.expertsclub.expertspaging3.R

data class Character(
    val id: Int,
    val name: String,
    val status: Status,
    val species: String,
    val imageUrl: String
)

sealed class Status(
    @StringRes val description: Int,
    @DrawableRes val imageResId: Int
) {
    object Alive : Status(R.string.characters_status_alive, R.drawable.status_alive)
    object Dead : Status(R.string.characters_status_dead, R.drawable.status_dead)
    object Unknown : Status(R.string.characters_status_unknown, R.drawable.status_unknonw)
}