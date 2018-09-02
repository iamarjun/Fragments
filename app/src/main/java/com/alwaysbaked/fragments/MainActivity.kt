package com.alwaysbaked.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fm: FragmentManager
    private lateinit var ft: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fm = supportFragmentManager
        tv_count.text = fm.backStackEntryCount.toString()

        fm.addOnBackStackChangedListener {
            tv_count.text = fm.backStackEntryCount.toString()
        }

        btn_add.setOnClickListener {
            addFragment()
        }
    }

    private fun addFragment() {
        val fragment: Fragment = when (fm.backStackEntryCount) {
            0 -> FragmentOne()
            1 -> FragmentTwo()
            2 -> FragmentThree()
            else -> FragmentOne()
        }

        ft = fm.beginTransaction()
        ft.add(R.id.container, fragment, "Frag")
                .addToBackStack(null)
                .commit()
    }
}
