package com.example.erbe.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.erbe.R
import com.example.erbe.remote.response.Result

class HomeAdapter(private val list: List<Result>): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title)
        val image: ImageView = view.findViewById(R.id.thumbnail)
        val publisher: TextView = view.findViewById(R.id.publisher)
        val description: TextView = view.findViewById(R.id.description)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.publisher.text = list[position].releaseDate
        holder.description.text = list[position].originalLanguage
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500/${list[position].posterPath}")
            .into(holder.image)


    }
    override fun getItemCount(): Int {
        return list.size
    }


}
