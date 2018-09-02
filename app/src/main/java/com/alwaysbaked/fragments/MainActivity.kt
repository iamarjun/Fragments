package com.alwaysbaked.fragments

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity(), ClickListener {

    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm = supportFragmentManager

        addCountryListFragment()

    }

    private fun addCountryListFragment() {
        val countryListFragment = CountryListFragment()
        countryListFragment.setClickListener(this)
        ft = fm.beginTransaction()
        ft.add(R.id.container, countryListFragment)
                .commit()
    }

    private fun addCountryDetailsFragment(country: String) {
        val countryDetailsFragment = CountryDetailsFragment()

        val bundle = Bundle()
        bundle.putString("Country", country)
        countryDetailsFragment.arguments = bundle

        ft = fm.beginTransaction()

        ft.replace(R.id.container, countryDetailsFragment)
                .addToBackStack(null)
                .commit()
    }

    override fun onCountrySelected(country: String) {
        addCountryDetailsFragment(country)
    }


}
