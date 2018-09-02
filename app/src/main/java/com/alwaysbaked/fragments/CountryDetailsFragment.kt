package com.alwaysbaked.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment_country_details.view.*


class CountryDetailsFragment : Fragment() {

    private lateinit var country: String
    private lateinit var countryDetails: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fragment_country_details, container, false)

        init(view)


        return view
    }

    private fun init(view: View) {
        val bundle = arguments
        country = bundle!!.getString("Country")
        countryDetails = getString(getCountryDetails(country))
        view.tv_country_details.text = countryDetails
    }

    private fun getCountryDetails(country: String): Int {
        return when (country) {
            "India" -> R.string.India
            "USA" -> R.string.USA
            "Pakistan" -> R.string.Pakistan
            "Bangladesh" -> R.string.Bangladesh
            "Egypt" -> R.string.Egypt
            "Indonesia" -> R.string.Indonesia
            "UK" -> R.string.UK
            "Germany" -> R.string.Germany

            else -> R.string.India
        }
    }

}
