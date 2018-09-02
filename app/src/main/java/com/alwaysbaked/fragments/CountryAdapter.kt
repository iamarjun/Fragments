package com.alwaysbaked.fragments

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.layout_country.view.*

class CountryAdapter(listener: RecyclerViewClickListener, private val countryList: List<String>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    private var mListener: RecyclerViewClickListener = listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_country, parent, false)

        return CountryViewHolder(view, mListener)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {

        holder.mCountry.text = countryList[position]
    }


    inner class CountryViewHolder(view: View, listener: RecyclerViewClickListener) : RecyclerView.ViewHolder(view), View.OnClickListener {

        private val mListener: RecyclerViewClickListener = listener
        val mCountry = view.tv_country_name!!

        init {

            view.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            mListener.onClick(v, adapterPosition)
        }
    }
}