package com.example.sportnews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportnews.R
import com.example.sportnews.models.Athlet

class AthletFragmentRVAdapter(private val context: Context, private val athlets: List<Athlet>): RecyclerView.Adapter<AthletFragmentRVAdapter.AdapterViewHolder>() {
    inner class AdapterViewHolder(item: View): RecyclerView.ViewHolder(item){
        val athletName = item.findViewById<TextView>(R.id.tvAthletName)
        val sport = item.findViewById<TextView>(R.id.tvAthletSport)
        val country = item.findViewById<TextView>(R.id.tvAthletCountry)
        val bestPerformace = item.findViewById<TextView>(R.id.tvAthletBestPerformance)
        val medals = item.findViewById<TextView>(R.id.tvAthletMedals)
        val facts = item.findViewById<TextView>(R.id.tvAthletFact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val item = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.athlet_item_view, parent, false)

        return AdapterViewHolder(item)
    }

    override fun getItemCount(): Int {
        return athlets.size
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        val athlet = athlets[position]

        holder.athletName.text = "Name: ${athlet.name}"
        holder.sport.text = "Sport: ${athlet.sportName}"
        holder.country.text = "Country: ${athlet.country}"
        holder.bestPerformace.text = "Personal Best: ${athlet.bestPerformance}"
        holder.medals.text = "Medals Awarded: ${athlet.medals.toString()}"
        holder.facts.text = "Facts: ${athlet.facts}"
    }
}