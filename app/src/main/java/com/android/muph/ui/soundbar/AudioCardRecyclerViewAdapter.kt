package com.android.muph.ui.soundbar

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.android.muph.R
import com.android.muph.model.Audio

class AudioCardRecyclerViewAdapter(
    private val audioList: List<Audio>,
) : RecyclerView.Adapter<AudioCardViewHolder>() {

    lateinit var onPlayClickListener: (Int) -> Unit//LiveData<Boolean>
    lateinit var onStarClickListener: (Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AudioCardViewHolder {
        val layoutView =
            LayoutInflater.from(parent.context).inflate(R.layout.audio_card, parent, false)
        return AudioCardViewHolder(layoutView)
    }

    override fun onBindViewHolder(holder: AudioCardViewHolder, position: Int) {
        if (position < audioList.size) {
            holder.audioDescription.text = audioList[position].description
            holder.itemBackground.setOnClickListener {
                onPlayClickListener(audioList[position].resId)
            }
            holder.starButton.setOnClickListener {
                onStarClickListener(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return audioList.size
    }
}
