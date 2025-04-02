package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HobbiesAdapter(private val context:Context, private val hobbies: List<Hobbies>):
    RecyclerView.Adapter<HobbiesAdapter.HobbiesViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HobbiesViewHolder {
      val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false)
        return HobbiesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: HobbiesViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class HobbiesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
            private var txvTitle: TextView = itemView.findViewById(R.id.txvTitle)
        fun setData(hobby: Hobbies?, pos:Int){
            txvTitle.text = hobby!!.title
        }
    }
}