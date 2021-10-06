package com.nkosi.roger.mobiquity.ui.product_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nkosi.roger.mobiquity.R
import com.nkosi.roger.mobiquity.model.Product
import com.nkosi.roger.mobiquity.utils.StringUtils
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.product_list.view.*

/**
 * Adapter for the list of products per category
 *
 */
class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    /**
     * The list of categories of the adapter
     */
    private var products: List<Product> = listOf()

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var foodName: TextView = itemView.food_name
        var productImage: CircleImageView = itemView.food_thumbnail
    }

    fun populateProducts(products: List<Product>) {
        this.products = products
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_list, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.foodName.text = products[position].name
        Glide
            .with(holder.itemView)
            .load(StringUtils.imageUri(products[position].url))
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_fastfood_24)
            .into(holder.productImage)
    }

    override fun getItemCount(): Int {
        return products.size
    }
}
