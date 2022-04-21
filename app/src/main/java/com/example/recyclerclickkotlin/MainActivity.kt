package com.example.recyclerclickkotlin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    // initialize variable
    var recyclerView: RecyclerView? = null
    var arrayList: ArrayList<String> = ArrayList()
    var adapter: MainAdapter? = null
    var itemClickListener: ItemClickListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // assign variable
        recyclerView=findViewById(R.id.recycler_view);

        // use for loop
        // use for loop
        for (i in 0..14) {
            // add values in array list
            arrayList.add("Address $i")
        }

        // Initialize listener
        // Initialize listener
        itemClickListener = object : ItemClickListener {
            override fun onClick(position: Int, value: String?) {
                // Display toast
                Toast.makeText(
                    applicationContext, "Position : "
                            + position + " || Value : " + value, Toast.LENGTH_SHORT
                ).show()
            }
        }


        // set layout manager
        // set layout manager
        recycler_view.setLayoutManager(LinearLayoutManager(this))
        // Initialize adapter
        // Initialize adapter
        adapter = MainAdapter(arrayList, itemClickListener as ItemClickListener)
        // set adapter
        // set adapter
        recycler_view.setAdapter(adapter)










    }
}