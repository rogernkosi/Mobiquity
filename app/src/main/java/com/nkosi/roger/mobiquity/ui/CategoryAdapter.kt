package com.nkosi.roger.mobiquity.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nkosi.roger.mobiquity.R
import com.nkosi.roger.mobiquity.model.Category
import kotlinx.android.synthetic.main.section_header.view.*

/**
 * Adapter for the list of product categories
 * @property context Context in which the application is running
 */
class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){

    /**
     * The list of categories of the adapter
     */
    private var productCategory: List<Category> = listOf()

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category: TextView = itemView.food_category
        var products: RecyclerView = itemView.product_recyclerview
    }

    /**
     * Updates the list of categories of the adapter
     * @param categories the new list of categories of the adapter
     */
    fun setData(categories: List<Category>) {
        this.productCategory = categories
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
         val itemView = LayoutInflater.from(parent.context).inflate(R.layout.section_header, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.category.text = productCategory[position].name
        val productAdapter  = ProductAdapter()
        productAdapter.populateProducts(productCategory[position].products)
        holder.products.adapter = productAdapter
    }

    override fun getItemCount(): Int {
        return productCategory.size
    }

}