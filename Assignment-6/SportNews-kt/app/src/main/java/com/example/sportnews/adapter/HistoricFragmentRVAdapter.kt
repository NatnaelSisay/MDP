package com.example.sportnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportnews.R
import com.example.sportnews.models.History

class HistoricFragmentRVAdapter(val historyList: List<History>): RecyclerView.Adapter<HistoricFragmentRVAdapter.HistoryViewHolder>()  {
    inner class HistoryViewHolder(item: View): RecyclerView.ViewHolder(item){
        val eventName = item.findViewById<TextView>(R.id.tvHistoryEventName)
        val eventDate = item.findViewById<TextView>(R.id.tvHistoryEventDate)
        val eventDescription = item.findViewById<TextView>(R.id.tvHistoryEventDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.history_item_view, parent, false)
        return HistoryViewHolder(item)
    }

    override fun getItemCount(): Int {
        return historyList.size
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val event = historyList[position]

        holder.eventName.text = event.eventName
        holder.eventDate.text = event.eventDate
        holder.eventDescription.text = event.eventDescription
    }
}