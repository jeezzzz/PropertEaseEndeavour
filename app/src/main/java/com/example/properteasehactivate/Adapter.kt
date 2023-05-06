package com.example.properteasehactivate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

data class Adapter(val list: List<House>): RecyclerView.Adapter<Adapter.ViewHolder>(){
    class ViewHolder ( view : View) : RecyclerView.ViewHolder(view) {
        val price: TextView = itemView.findViewById(R.id.price)
        val bhk: TextView = itemView.findViewById(R.id.bhk)
        val sqft: TextView = itemView.findViewById(R.id.sqft)
        val photo: ImageView = itemView.findViewById(R.id.house)
        
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view : View = inflater.inflate(R.layout.list,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentHouse = list[position]
        holder.price.text = list[position].price
        holder.bhk.text = list[position].bhk
        holder.sqft.text = list[position].sqft
        Glide.with(holder.itemView)
            .load(currentHouse.photo)
            .into(holder.photo)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}