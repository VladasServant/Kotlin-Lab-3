package com.example.lab3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhoneAdapter(private val phoneList: List<NewData>): RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    inner class PhoneViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val brandTextView: TextView = view.findViewById(R.id.textBrand)
        val modelTextView: TextView = view.findViewById(R.id.textModel)
        val releaseYearTextView: TextView = view.findViewById(R.id.textReleaseYear)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.new_data, parent, false)
        return PhoneViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val phone = phoneList[position]
        holder.brandTextView.text = phone.brand
        holder.modelTextView.text = phone.model
        holder.releaseYearTextView.text = phone.releaseYear
    }

    override fun getItemCount(): Int {
        return phoneList.size
    }
}