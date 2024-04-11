package com.example.sportnews.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportnews.adapter.EventFragmentRVAdapter
import com.example.sportnews.databinding.FragmentEventBinding
import com.example.sportnews.dialogs.AddEventDialog
import com.example.sportnews.models.Event

class EventFragment(private val context: Context) : Fragment() {
    private lateinit var binding: FragmentEventBinding
    private var events = this.getSampleData()
    private var eventAdapter = EventFragmentRVAdapter(events)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEventBinding.inflate(inflater, container, false)

        val rv = binding.rvEventFragmentRV
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = eventAdapter

        val fabAddEvent = binding.fabAddEvent
        val addEventDialog = AddEventDialog(context, this)
        fabAddEvent.setOnClickListener {
            addEventDialog.show(this.childFragmentManager, "Add Event")
        }
        return binding.root
    }

    fun addNews(newEventDialog: Event) {
//        val event = Event("Ev", "val", "val desc")
        events.add(newEventDialog)
        eventAdapter.notifyDataSetChanged()
    }

    private fun getSampleData():MutableList<Event> {
        return mutableListOf(
            Event("FIBA Basketball World Cup Qualifiers", "2024-01-04", "Qualifing Games for 2025"),
            Event("Another Basketball World Cup Qualifiers", "2025-01-04", "Qualifing Games for 2025")
        )
    }
}