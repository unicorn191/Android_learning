package com.example.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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
        private var imgShare:ImageView = itemView.findViewById(R.id.imgShare)
        var currentHobby:Hobbies? = null
        var currentPosition:Int = 0

        init {
            itemView.setOnClickListener {
                Toast.makeText(context,currentHobby!!.title, Toast.LENGTH_SHORT).show()
            }

            imgShare.setOnClickListener {
                val msg:String = currentHobby!!.title
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, msg )
                intent.type = "text/plain"
                context.startActivity(Intent.createChooser(intent,"share to:"))
            }
        }

        fun setData(hobby: Hobbies?, pos:Int){
            txvTitle.text = hobby!!.title
            this.currentHobby = hobby
            this.currentPosition = pos
        }
    }
}