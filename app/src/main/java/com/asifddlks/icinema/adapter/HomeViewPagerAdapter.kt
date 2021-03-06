package com.asifddlks.icinema.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.asifddlks.icinema.databinding.ItemHomeViewPagerBinding

//
// Created by Asif Ahmed on 20/1/22.
//
class HomeViewPagerAdapter() : RecyclerView.Adapter<HomeViewPagerAdapter.ViewPagerViewHolder>() {

    private val dataList: List<String> =
        mutableListOf("Inception", "Spider-Man", "Captain Marvel")

    class ViewPagerViewHolder(val binding: ItemHomeViewPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding =
            ItemHomeViewPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.binding.textViewTitle.text = dataList[position]
    }

    override fun getItemCount(): Int = dataList.size
}