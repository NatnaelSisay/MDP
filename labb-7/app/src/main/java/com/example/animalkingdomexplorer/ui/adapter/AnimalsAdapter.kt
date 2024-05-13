package com.example.animalkingdomexplorer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.animalkingdomexplorer.databinding.AnimalListViewBinding
import com.example.animalkingdomexplorer.model.Animal

class AnimalsAdapter : ListAdapter<Animal, AnimalsAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(var binding: AnimalListViewBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.animalName.text = getItem(position).animalName
        holder.binding.animalHabitat.text = getItem(position).habitat
        holder.binding.animalDiet.text = getItem(position).diet
    }

    fun setAnimals(animals: List<Animal>) {
        submitList(animals)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(AnimalListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    companion object {
        val DIFF_CALLBACK =  object : DiffUtil.ItemCallback<Animal>() {
            override fun areItemsTheSame(oldItem: Animal, newItem: Animal): Boolean {

                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(oldItem: Animal, newItem: Animal): Boolean {
                return oldItem == newItem
            }
        }
    }
}