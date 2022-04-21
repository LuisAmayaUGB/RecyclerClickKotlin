package com.example.recyclerclickkotlin

interface ItemClickListener {
    fun onClick(position: Int, value: String?)
}