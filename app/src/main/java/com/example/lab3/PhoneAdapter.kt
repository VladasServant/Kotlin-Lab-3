package com.example.lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhoneAdapter(private val phoneList: List<ItemInterface>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class BrandViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val brandTextView: TextView = view.findViewById(R.id.textBrand)
        val foundedDateTextView: TextView = view.findViewById(R.id.textFoundedDate)
        val aboutCompanyTextView: TextView = view.findViewById(R.id.textAboutCompany)
    }

    inner class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val modelNameTextView: TextView = view.findViewById(R.id.textModelName)
        val releaseYearTextView: TextView = view.findViewById(R.id.textReleaseYear)
    }

    override fun getItemViewType(position: Int): Int {
        return phoneList[position].getItemType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ItemInterface.Brand -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.new_data, parent, false)
                BrandViewHolder(view)
            }
            ItemInterface.Model -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.add_new_data, parent, false)
                ModelViewHolder(view)
            }
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = phoneList[position]) {
            is BrandData -> {
                val brandHolder = holder as BrandViewHolder
                brandHolder.brandTextView.text = item.brand
                brandHolder.foundedDateTextView.text = item.foundedDate
                brandHolder.aboutCompanyTextView.text = item.aboutCompany
            }
            is ModelData -> {
                val modelHolder = holder as ModelViewHolder
                modelHolder.modelNameTextView.text = item.modelName
                modelHolder.releaseYearTextView.text = item.releaseYear
            }
        }
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }
}
