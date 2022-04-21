package com.example.recyclerclickkotlin


import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class MainAdapter     // create constructor
    (// initialize variables
    var arrayList: ArrayList<String>, var itemClickListener: ItemClickListener
) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    var selectedPosition = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Initialize view
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main, parent, false)
        // return holder
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // set value on text view
        holder.textView.text = arrayList[position]
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                // get adapter position
                val position = holder.adapterPosition
                // call listener
                itemClickListener.onClick(position, arrayList[position])
                // update position
                selectedPosition = position
                // notify
                notifyDataSetChanged()
            }
        })

        // check conditions
        if (selectedPosition == position) {
            // When current position is equal
            // to selected position
            // set black background color
            holder.cardView.setCardBackgroundColor(Color.parseColor("#000000"))
            // set white text color
            holder.textView.setTextColor(Color.parseColor("#FFFFFF"))
        } else {
            // when current position is different
            // set white background
            holder.cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
            // set black text color
            holder.textView.setTextColor(Color.parseColor("#000000"))
        }
    }

    override fun getItemCount(): Int {
        // return array list size
        return arrayList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // initialize variable
        var cardView: CardView
        var textView: TextView

        init {
            // assign variable

            cardView = itemView.findViewById(R.id.card_view)
            textView = itemView.findViewById(R.id.text_View)
        }
    }
}