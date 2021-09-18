package com.android.muph.ui.soundbar

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.android.muph.R

class AudioCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var audioDescription: TextView = itemView.findViewById(R.id.textDescription)
    var itemBackground: ConstraintLayout = itemView.findViewById(R.id.layoutBackground)
    var playButton: Button = itemView.findViewById(R.id.buttonPlay)
    var starButton: Button = itemView.findViewById(R.id.buttonStar)

}
