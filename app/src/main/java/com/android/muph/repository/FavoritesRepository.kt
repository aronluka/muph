package com.android.muph.repository

import android.content.Context
import androidx.core.content.edit
import com.android.muph.model.FavoritesList
import com.android.muph.utils.fromJson
import com.android.muph.utils.toJson

class FavoritesRepository(context: Context) {

    companion object {
        const val SP_NAME = "favorites_prefs"
        const val KEY_FAVORITES = "favorites"
    }

    private val prefs = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE)!!

    var favorites
        get() = prefs.getString(KEY_FAVORITES, null)?.fromJson<FavoritesList>()
        set(value) = prefs.edit { putString(KEY_FAVORITES, value.toJson()) }

    fun save(position: Int) {
        favorites = FavoritesList(favorites!!.list + position)
    }

}