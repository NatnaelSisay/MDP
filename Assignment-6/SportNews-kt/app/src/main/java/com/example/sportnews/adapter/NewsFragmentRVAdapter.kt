package com.example.sportnews.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sportnews.R
import com.example.sportnews.models.News

class NewsFragmentRVAdapter(val context: Context, val newses: List<News>): RecyclerView.Adapter<NewsFragmentRVAdapter.NewsViewHolder>() {
    inner class NewsViewHolder(item: View): RecyclerView.ViewHolder(item){
        val image = item.findViewById<ImageView>(R.id.imgNewsImage)
        val newsTitle = item.findViewById<TextView>(R.id.tvNewsTitle)
        val newsDescription = item.findViewById<TextView>(R.id.tvNewsDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.news_item_view, parent, false)
        return NewsViewHolder(item)
    }

    override fun getItemCount(): Int {
        return newses.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = newses[position]

        Glide.with(context).load(news.imageUrl).into(holder.image);
        holder.newsTitle.text = news.newsTitle
        holder.newsDescription.text = news.newsDescription
    }
}