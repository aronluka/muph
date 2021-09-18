package com.android.muph.repository

import android.content.Context

class RepositoryProvider {

    companion object {
        lateinit var favsRep: FavoritesRepository

        fun init(context: Context) {
            favsRep = FavoritesRepository(context)
        }
    }
}
