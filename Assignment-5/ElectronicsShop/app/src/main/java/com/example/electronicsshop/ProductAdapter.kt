package com.example.electronicsshop

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(
    val context: Context,
    val productList: ArrayList<Product>
): RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    inner class ViewHolder(val item: View): RecyclerView.ViewHolder(item){
        val tvMainProductTitle = item.findViewById<TextView>(R.id.tvMainProductTitle)
        val tvMainProductDetail = item.findViewById<TextView>(R.id.tvMainProductDetail)
        val tvMainProductPrice = item.findViewById<TextView>(R.id.tvMainProductPrice)
        val imgMainProductLogo = item.findViewById<ImageView>(R.id.imgMainProductLogo)
        val imgMainProductImage = item.findViewById<ImageView>(R.id.imgMainProductImage)
        val btn = item.findViewById<Button>(R.id.btnMainAddToCart)

        fun bind(product: Product){
            item.setOnClickListener{
                val intent = Intent(context, ProductDetailActivity::class.java)
                intent.putExtra("EXTRA_PRODUCT", product)
                context.startActivity(intent)
            }

            btn.setOnClickListener {
                Toast.makeText(context, "${tvMainProductTitle.text} Added to Cart", Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
                    .from(parent.context)
                    .inflate(R.layout.product_layout, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]

        holder.apply {
            tvMainProductTitle.text = product.name
            tvMainProductDetail.text = product.description
            tvMainProductPrice.text = product.price.toString()
            imgMainProductLogo.setImageResource(product.logo)
            imgMainProductImage.setImageResource(product.image)
        }

        holder.bind(product)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}