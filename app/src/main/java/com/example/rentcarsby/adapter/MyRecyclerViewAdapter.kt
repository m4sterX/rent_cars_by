package com.example.rentcarsby.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.rentcarsby.R
import com.example.rentcarsby.data_base.entity.CarEntity
import java.util.*


class MyRecyclerViewAdapter(
    private val onItemClicked: (position: Int) -> Unit,
    mCarsList: ArrayList<CarEntity>
) : RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {
    private val carsList = mCarsList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)

        val myViewHolder = MyViewHolder(view, onItemClicked)
        val position = myViewHolder.adapterPosition
        if (position != RecyclerView.NO_POSITION) {
            myViewHolder.itemView.setOnClickListener {
                Toast.makeText(parent.context, myViewHolder.adapterPosition, Toast.LENGTH_LONG)
                    .show()

            }
        }
        return MyViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = carsList[position]
        holder.img.setImageResource(currentItem.previewImage)
        holder.name.text = currentItem.name
    }

    override fun getItemCount(): Int {
        return carsList.size
    }

    inner class MyViewHolder(itemView: View, onItemClicked: (position: Int) -> Unit) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val img: ImageView = itemView.findViewById(R.id.imageview_preview)
        val name = itemView.findViewById<TextView>(R.id.textview_car_name)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            onItemClicked(position)
        }
    }
}

