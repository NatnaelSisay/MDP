package com.example.sportnews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sportnews.R
import com.example.sportnews.models.Event

class EventFragmentRVAdapter(val events: List<Event> )
    : RecyclerView.Adapter<EventFragmentRVAdapter.EventViewHolder>(){
        inner class EventViewHolder(item: View): RecyclerView.ViewHolder(item){
            val eventName = item.findViewById<TextView>(R.id.tvHistoryEventName)
            val eventDate = item.findViewById<TextView>(R.id.tvHistoryEventDate)
            val eventDescription = item.findViewById<TextView>(R.id.tvHistoryEventDescription)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.event_item_view, parent, false)

        return EventViewHolder(item)
    }

    override fun getItemCount(): Int {
        return events.size
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = events[position]

        holder.eventName.text = event.eventName
        holder.eventDate.text = event.date
        holder.eventDescription.text = event.eventDescription
    }
}