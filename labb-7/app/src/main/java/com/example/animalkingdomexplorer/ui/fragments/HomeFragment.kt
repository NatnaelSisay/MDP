package com.example.animalkingdomexplorer.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.animalkingdomexplorer.R
import com.example.animalkingdomexplorer.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        (activity as AppCompatActivity).supportActionBar?.title = "Home"

        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.animalDetailsButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_animalsDetailsFragment)
        }
        binding.speciesDetailsButton.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_speciesDetailsFragment)
        }

        return binding.root
    }

}