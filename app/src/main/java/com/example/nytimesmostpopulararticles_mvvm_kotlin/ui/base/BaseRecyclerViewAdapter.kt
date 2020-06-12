package com.example.nytimesmostpopulararticles_mvvm_kotlin.ui.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerViewAdapter<T>(val items: MutableList<T>, val itemListener: BaseItemListener<T>) :
    RecyclerView.Adapter<BaseViewHolder>() {
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItems(items: List<T>?) {
        items?.let { this.items.addAll(it) }
        notifyDataSetChanged()
    }

    fun clearItems() {
        items.clear()
    }

}