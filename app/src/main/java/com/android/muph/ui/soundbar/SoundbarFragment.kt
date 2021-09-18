package com.android.muph.ui.soundbar

import android.media.MediaPlayer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.muph.databinding.FragmentHomeBinding
import com.android.muph.model.AudioList
import kotlin.random.Random

class SoundbarFragment : Fragment() {

    private lateinit var soundbarViewModel: SoundbarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        soundbarViewModel = ViewModelProvider(this).get(SoundbarViewModel::class.java)

        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.recyclerView.adapter = AudioCardRecyclerViewAdapter(AudioList.values).apply {
            onPlayClickListener = { MediaPlayer.create(context, it).start() }
            onStarClickListener = { soundbarViewModel.saveFavorite(it) }
        }

        binding.fabRandom.setOnClickListener {
            MediaPlayer.create(
                context, AudioList.values[Random.nextInt(1, AudioList.values.size) - 1].resId
            ).start()
        }

        return binding.root
    }
}