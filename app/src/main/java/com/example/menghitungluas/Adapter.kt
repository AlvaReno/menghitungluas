package com.example.menghitungluas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter (private val itung : ArrayList<data>) :
    RecyclerView.Adapter<Adapter.viewholder>() {
    class viewholder(view: View) : RecyclerView.ViewHolder(view) {
        val hasil = view.findViewById<TextView>(R.id.hasil)
        val btnHapus = view.findViewById<ImageView>(R.id.btnHapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_adapter, parent, false)
        )
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val data = itung[position]
        holder.hasil.text = data.hasil.toString()
        holder.btnHapus.setOnClickListener {
            itung.removeAt(position)
            notifyItemRangeRemoved(position, itung.size)
            notifyDataSetChanged()
        }
    }
        override fun getItemCount(): Int = itung.size

    }

