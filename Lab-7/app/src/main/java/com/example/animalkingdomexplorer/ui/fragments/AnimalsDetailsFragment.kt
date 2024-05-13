package com.example.animalkingdomexplorer.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animalkingdomexplorer.ui.adapter.AnimalsAdapter
import com.example.animalkingdomexplorer.databinding.FragmentAnimalsDetailsBinding
import com.example.animalkingdomexplorer.dialog.AddAnimalsDialog

class AnimalsDetailsFragment : Fragment() {

    lateinit var binding: FragmentAnimalsDetailsBinding
    private val viewModel: AnimalsDetailsFragmentViewModel by viewModels {
        AnimalsDetailsFragmentViewModel.Factory(
            requireContext()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        (activity as AppCompatActivity).supportActionBar?.title = "Animals Details"

        binding = FragmentAnimalsDetailsBinding.inflate(layoutInflater, container, false)

        val adapter = AnimalsAdapter()
        binding.animalRecyclerView.adapter = adapter
        binding.animalRecyclerView.layoutManager = LinearLayoutManager(this.context)

        viewModel.animals.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.floatingActionButton2.setOnClickListener {
            val dialog = AddAnimalsDialog { animal ->
                viewModel.insertAnimal(animal)
            }
            dialog.show(childFragmentManager, "AddSpeciesDialog")
        }
        return binding.root
    }
}