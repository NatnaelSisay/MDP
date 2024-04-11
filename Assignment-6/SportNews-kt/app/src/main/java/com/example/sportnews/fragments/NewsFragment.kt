package com.example.sportnews.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportnews.R
import com.example.sportnews.adapter.NewsFragmentRVAdapter
import com.example.sportnews.databinding.FragmentNewsBinding
import com.example.sportnews.dialogs.AddNewsDialog
import com.example.sportnews.models.News

class NewsFragment(private val context: Context) : Fragment() {
    private lateinit var binding: FragmentNewsBinding
    private var newses = this.getSampleData()
    val newsFragmentAdapter = NewsFragmentRVAdapter(context, newses)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)

        val rv = binding.rvNewsFragmentRV
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = newsFragmentAdapter

        val fab = binding.fabSports
        val dialog = AddNewsDialog(context, this)

        fab.setOnClickListener {
            dialog.show(this.childFragmentManager, "Add News")
        }

        return binding.root;
    }

    fun addNews(newNews: News) {
        this.newses.add(newNews)
        newsFragmentAdapter.notifyDataSetChanged()
    }

    private fun getSampleData(): MutableList<News>{
        return mutableListOf(
            News(
                "https://assets1.cbsnewsstatic.com/hub/i/r/2021/12/24/a8630ada-136b-41f3-8ce0-cd507656b680/thumbnail/1200x630/7fdf962dad76d9340e995341e1df72ce/A7CAEF02D16FCE12263DED7A5628502C.jpg",
                "Colledge Basketball takeaways: Classic UNC-Duke rivilary game turns into ugly scence as taunts, drinkers lobbed",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec urna sed nisi bibendum aliquet. Sed suscipit purus vel nunc vestibulum, id fermentum ligula varius. Nam auctor consequat sem, id feugiat mi consequat eget. "
            ),
            News(
                "https://cheflolaskitchen.com/wp-content/uploads/2021/05/DSC1090-Injera-Ethopian.jpg",
                "Ethiopian Injera is considered one of the super foods athlets need to eat to stay strong and healthy without the worry of colestrol",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer nec urna sed nisi bibendum aliquet. Sed suscipit purus vel nunc vestibulum, id fermentum ligula varius. Nam auctor consequat sem, id feugiat mi consequat eget. "
            )
        )
    }
}