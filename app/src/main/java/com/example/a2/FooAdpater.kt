package com.example.a2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sample.databinding.ItemFooBinding


// RecyclerView.Adapter 를 상속받는 Adapter

class FooAdapter(
    private val onItemClick: (PickerItem) -> Unit
) : RecyclerView.Adapter<FooAdapter.ViewHolder>() {

    private val items = mutableListOf<PickerItem>()

    fun addItems(newItems : List<PickerItem>) {
        items.addAll(newItems)
        notifyItemRangeInserted(items.size, newItems.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context)
        val binding = ItemFooBinding.inflate(inflatedView, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])

        Glide.with(holder.itemView.getContext())
            .load(items[position].imageUri)
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(
        private val binding : ItemFooBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item : PickerItem) {
            binding.apply {
/*                tvName.text = item.name
                tvPhone.text = item.phone*/

                itemView.setOnClickListener {

                }
            }
        }
    }

}