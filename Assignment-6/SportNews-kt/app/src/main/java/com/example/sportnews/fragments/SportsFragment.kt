package com.example.sportnews.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sportnews.adapter.SportFragmentRVAdapter
import com.example.sportnews.models.Sport
import com.example.sportnews.databinding.FragmentSportsBinding
import com.example.sportnews.dialogs.AddSportDialog

class SportsFragment(private val context: Context) :
    Fragment(){
    private lateinit var binding: FragmentSportsBinding
    private var sports:MutableList<Sport> = getSampleData();
    private val adapter = SportFragmentRVAdapter(context, sports)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSportsBinding.inflate(inflater, container, false)

        val rv = binding.rvSportsFragmentRV
        rv.layoutManager = GridLayoutManager(context, 2);
        rv.adapter = adapter
//
        val addSportsDialog = AddSportDialog(context, this)
        val fab = binding.fabSports
        fab.setOnClickListener{
            addSportsDialog.show(this.childFragmentManager,"Add Sport Dialog")
        }

        return binding.root
    }

    fun addNewSport(newSport: Sport){
        sports.add(newSport)
        adapter.notifyDataSetChanged()
    }

    fun getSampleData(): MutableList<Sport>{
        return mutableListOf(
            Sport(
                "Measure",
                "Car Racing",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec urna sed nisi bibendum aliquet. Sed suscipit purus vel nunc vestibulum, id fermentum ligula varius. Nam auctor consequat sem, id feugiat mi consequat eget. Nullam at nisi nec velit tempor suscipit. Phasellus vitae orci ut ipsum aliquet fermentum. Ut ultricies quam nec nunc scelerisque, nec accumsan est tempus. Mauris et ligula dapibus, varius libero nec, tincidunt magna. Aliquam erat volutpat. Vivamus nec libero aliquam, viverra enim at, posuere ex"
            ),
            Sport(
                "Precision",
                "Golf",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec urna sed nisi bibendum aliquet. Sed suscipit purus vel nunc vestibulum, id fermentum ligula varius. Nam auctor consequat sem, id feugiat mi consequat eget. Nullam at nisi nec velit tempor suscipit. Phasellus vitae orci ut ipsum aliquet fermentum. Ut ultricies quam nec nunc scelerisque, nec accumsan est tempus. Mauris et ligula dapibus, varius libero nec, tincidunt magna. Aliquam erat volutpat. Vivamus nec libero aliquam, viverra enim at, posuere ex"
            )
        )
    }
}