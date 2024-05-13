package com.example.animalkingdomexplorer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animalkingdomexplorer.ui.adapter.SpeciesAdapter
import com.example.animalkingdomexplorer.databinding.FragmentSpeciesDetailsBinding
import com.example.animalkingdomexplorer.dialog.AddSpeciesDialog

class SpeciesDetailsFragment : Fragment() {

    lateinit var binding: FragmentSpeciesDetailsBinding
    private val viewModel: SpeciesDetailsFragmentViewModel by viewModels {
        SpeciesDetailsFragmentViewModel.Factory(
            requireContext()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (activity as AppCompatActivity).supportActionBar?.title = "Species Details"

        binding = FragmentSpeciesDetailsBinding.inflate(layoutInflater, container, false)
        val adapter = SpeciesAdapter()
        binding.speciesRecyclerView.adapter = adapter
        binding.speciesRecyclerView.layoutManager = LinearLayoutManager(this.context)
        viewModel.species.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.floatingActionButton.setOnClickListener {
            val dialog = AddSpeciesDialog { species ->
                viewModel.insertSpecies(species)
            }
            dialog.show(childFragmentManager, "AddSpeciesDialog")
        }

        return binding.root
    }
}