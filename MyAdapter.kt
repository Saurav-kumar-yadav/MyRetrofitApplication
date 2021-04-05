package com.example.retrofitapplication

import android.content.Context
import android.graphics.Color
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapplication.R.id.image
import com.example.retrofitapplication.R.id.teamTV
import com.example.retrofitapplication.R.layout.item_view
import com.example.retrofitapplication.model.ResponseData
import com.squareup.picasso.Picasso

class MyAdapter (val reposedata: List<ResponseData>):RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater:LayoutInflater = LayoutInflater.from(parent.context)
        val view:View = inflater.inflate(item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.name.text = reposedata[position].name
        holder.realname.text = reposedata[position].realname
        holder.team.text = reposedata[position].team
        holder.publisher.text = reposedata[position].publisher
        holder.bio.text = reposedata[position].bio
        holder.firstapperance.text = reposedata[position].firstappearance
        holder.createdby.text = reposedata[position].createdby

        val imgURL: String? = reposedata[position].imageurl
        Picasso.get().load(imgURL).into(holder.image) ;
//        Picasso.get()
//            .load(imgURL)
//            .resize(150, 150) // here you resize your image to whatever width and height you like
//            .into(holder.image)

        var color = "#B4D5FE"
        if(position%2==0){
            color = "#3298FD"
        }
        holder.container.setBackgroundColor(Color.parseColor(color))
    }

    override fun getItemCount(): Int {
       return reposedata.size
    }
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
      var name = itemView.findViewById<TextView>(R.id.nameTV)
      var realname = itemView.findViewById<TextView>(R.id.realnameTV)
      var team = itemView.findViewById<TextView>(teamTV)
      var publisher = itemView.findViewById<TextView>(R.id.publisherTV)
      var bio = itemView.findViewById<TextView>(R.id.bioTV)
      var firstapperance = itemView.findViewById<TextView>(R.id.firstappearanceTV)
      var createdby = itemView.findViewById<TextView>(R.id.createdbyTV)
      var image = itemView.findViewById<ImageView>(R.id.imageIV)

      var container = itemView.findViewById<ConstraintLayout>(R.id.viewcontainer)
    }
}

