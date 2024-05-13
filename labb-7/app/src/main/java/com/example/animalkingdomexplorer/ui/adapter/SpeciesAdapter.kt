package com.example.animalkingdomexplorer.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.animalkingdomexplorer.databinding.SpeciesListViewBinding
import com.example.animalkingdomexplorer.model.Species


class SpeciesAdapter : ListAdapter<Species, SpeciesAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(var binding: SpeciesListViewBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.speciesName.text = getItem(position).speciesName
        holder.binding.speciesDescription.text = getItem(position).speciesDescription
    }

    fun setSpecies(species: List<Species>) {
        submitList(species)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(SpeciesListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    companion object {
        val DIFF_CALLBACK =  object : DiffUtil.ItemCallback<Species>() {
            override fun areItemsTheSame(oldItem: Species, newItem: Species): Boolean {

                return oldItem.uid == newItem.uid
            }

            override fun areContentsTheSame(oldItem: Species, newItem: Species): Boolean {
                return oldItem == newItem
            }
        }
    }
}