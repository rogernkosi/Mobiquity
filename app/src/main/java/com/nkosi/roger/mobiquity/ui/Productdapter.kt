package com.nkosi.roger.mobiquity.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.nkosi.roger.mobiquity.R
import com.nkosi.roger.mobiquity.model.Category
import kotlinx.android.synthetic.main.product_list.view.*
import kotlinx.android.synthetic.main.section_header.view.*

/**
 * Adapter for the list of product categories
 * @property context Context in which the application is running
 */
class Productdapter (private val context: Context) : RecyclerView.Adapter<Productdapter.CategoryViewHolder>(){

    /**
     * The list of categories of the adapter
     */
    private var productCategory: List<Category> = listOf()

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var foodName: TextView = itemView.food_name
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var category: TextView = itemView.food_category
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
         val itemView = LayoutInflater.from(context).inflate(R.layout.section_header, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val headerViewHolder: CategoryViewHolder = holder
        headerViewHolder.category.text = productCategory[position].name
    }

    override fun getItemCount(): Int {
        return productCategory.size
    }
}