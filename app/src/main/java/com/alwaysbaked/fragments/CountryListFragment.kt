package com.alwaysbaked.fragments

import android.content.Context
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment_country_list.view.*

class CountryListFragment : Fragment(), RecyclerViewClickListener {

    private lateinit var countryList: List<String>
    private var mContext: Context? = null
    private lateinit var adapter: CountryAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var mClickListener: ClickListener


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment_country_list, container, false)

        init(view)

        return view
    }

    override fun onClick(view: View, position: Int) {
        Snackbar.make(view, "Clicked: $position", Snackbar.LENGTH_SHORT)
        mClickListener.onCountrySelected(countryList[position])
    }

    fun setClickListener(clickListener: ClickListener) {
        mClickListener = clickListener
    }

    private fun init(view: View) {
        mContext = context
        countryList = resources.getStringArray(R.array.countries).toList()

        layoutManager = LinearLayoutManager(context)

        view.country_list.layoutManager = layoutManager

        adapter = CountryAdapter(this, countryList)

        view.country_list.adapter = adapter

    }

}
