package com.example.sportnews.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportnews.adapter.AthletFragmentRVAdapter
import com.example.sportnews.databinding.FragmentAthletsBinding
import com.example.sportnews.dialogs.AddAthletDialog
import com.example.sportnews.models.Athlet

class AthletsFragment(private val context: Context) : Fragment() {
    private lateinit var binding: FragmentAthletsBinding
    private val athlets = this.getSampleData()
    private val athletAdapter = AthletFragmentRVAdapter(context, athlets)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAthletsBinding.inflate(inflater, container, false)

        val rv = binding.rvAthletFragmentRV
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = athletAdapter

        val fabAddAthlets = binding.fabAddAthlets
        val addAthletDialog = AddAthletDialog(context, this)

        fabAddAthlets.setOnClickListener {
            addAthletDialog.show(this.childFragmentManager, "Add Athlet")
        }

        return binding.root
    }

    fun addNewSport(newAthlet: Athlet) {
        athlets.add(newAthlet)
        athletAdapter.notifyDataSetChanged()
    }

    private fun  getSampleData(): MutableList<Athlet>{
        return mutableListOf(
            Athlet(
                "Usian Bolt",
                "Track and Field",
                "Jamica",
                "100m - 9.85",
                8,
                "Usian bolt holds the world record for both the 100 and 200 meter race"
            ),
            Athlet(
                "Hile G/Silase",
                "Track and Field",
                "Ethiopia",
                "42km Marathon - 2:10hr",
                48,
                "Hile G/Silase has broken world records in marathon and other races. He is truly legend"
            )
        )
    }
}