package com.android.muph.ui.soundbar

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.android.muph.repository.RepositoryProvider

class SoundbarViewModel(app: Application) : AndroidViewModel(app) {

    fun saveFavorite(int: Int) {
        RepositoryProvider.favsRep.save(int)
    }

}