package com.alwaysbaked.fragments

import android.view.View

interface RecyclerViewClickListener {

    fun onClick(view: View, position: Int)
}