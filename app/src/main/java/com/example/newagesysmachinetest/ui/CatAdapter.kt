package com.example.newagesysmachinetest.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newagesysmachinetest.Model.Model
import com.example.newagesysmachinetest.R
import de.hdodenhof.circleimageview.CircleImageView


class CatAdapter(private val context: Context, private var cats: List<Model>) :
    RecyclerView.Adapter<CatAdapter.CatViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val cat = cats[position]
        Log.d("dattteeee", "onBindViewHolder: " + cat.date)
        holder.date.text=cat.date
        holder.title.text=cat.id
        if(holder.image!=null){
        Glide.with(context).load(cat.url).into(holder.image)}
        else{
            holder.image.setImageResource(R.drawable.ic_launcher_background)
        }
        holder.card.setOnClickListener(View.OnClickListener {

            val intent = Intent(context,DetailActivity::class.java)
            intent.putExtra("title",cat.id)
            intent.putExtra("date", cat.date)
            intent.putExtra("explanation", cat.explanation)
            intent.putExtra("image", cat.url)

            context.startActivity(intent)
        })

        // Picasso.get().load(cat.url).into(holder.image)
    }

    override fun getItemCount(): Int {
        return cats.size
    }

    fun getAllDatas(cats: List<Model>) {
        this.cats = cats
    }

    class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image: CircleImageView
        var date: TextView
        var title: TextView
        var card: ConstraintLayout


        init {
            image = itemView.findViewById(R.id.planetImage)
            date = itemView.findViewById(R.id.dateName)
            title = itemView.findViewById(R.id.textView)
            card = itemView.findViewById(R.id.card_view)


        }
    }
}