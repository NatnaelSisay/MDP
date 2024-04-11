package com.example.sportnews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportnews.R
import com.example.sportnews.models.Sport

class SportFragmentRVAdapter(
    val context: Context,
    private val sports: List<Sport>
) : RecyclerView.Adapter<SportFragmentRVAdapter.SportsViewHolder>() {
    inner class SportsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val tvSportType: TextView = item.findViewById(R.id.tvSportType)
        val tvSportName: TextView = item.findViewById(R.id.tvSportName)
        val tvSportDescription: TextView = item.findViewById(R.id.tvSportDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.sport_item_view, parent, false)
        return SportsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SportsViewHolder, position: Int) {
        val sport = sports[position];

        holder.tvSportType.text = sport.type
        holder.tvSportName.text = sport.name
        holder.tvSportDescription.text = sport.description
    }

    override fun getItemCount(): Int {
        return sports.size
    }
}