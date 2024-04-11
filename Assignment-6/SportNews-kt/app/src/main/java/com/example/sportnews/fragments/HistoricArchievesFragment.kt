package com.example.sportnews.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportnews.adapter.HistoricFragmentRVAdapter
import com.example.sportnews.databinding.FragmentHistoricArchievesBinding
import com.example.sportnews.dialogs.AddHistoricDialog
import com.example.sportnews.models.History

class HistoricArchievesFragment(private val context: Context) : Fragment() {
    private lateinit var binding: FragmentHistoricArchievesBinding
    private var historyArchieves = this.getSampleData()
    val historicAdapter = HistoricFragmentRVAdapter(historyArchieves)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHistoricArchievesBinding.inflate(inflater, container, false)

        val rv = binding.rvHistoryRV
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = historicAdapter

        val fabAddHistory = binding.fabAddHistory
        val historyDialog = AddHistoricDialog(context, this)
        fabAddHistory.setOnClickListener {
            historyDialog.show(this.childFragmentManager, "Add Historic Event")
        }

        return binding.root
    }

    fun addNews(newHistoryEvent: History) {
        historyArchieves.add(newHistoryEvent)
        historicAdapter.notifyDataSetChanged()
    }

    private fun getSampleData(): MutableList<History>{
        return mutableListOf(
            History("First Modern Olympic Game", "April 6, 1999", "The first moden olympic games were held in Athens, ...."),
            History("Second Modern Olympic Game", "April 6, 2003", "The first moden olympic games were held in Athens, ....")
        )
    }
}