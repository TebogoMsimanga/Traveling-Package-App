package com.example.travelingpackage.ui.logic

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel(){
    private val _privateList = mutableStateListOf<PackingItem>()

    val packingList: List<PackingItem> get() = _privateList

    init {
        _privateList.add(PackingItem("Sneakers", "Shoes", 3, "For running"))
        _privateList.add(PackingItem("Ear rings", "Accessories", 5, "Dinner"))
        _privateList.add(PackingItem("Make up", "Toiletry", 1, "Face beat"))
        _privateList.add(PackingItem("Dresses", "Clothes", 5, "Dates"))
    }
    fun addItem (item: PackingItem){
        _privateList.add(item)
    }
    fun getAllItems(): List<PackingItem>{
        return _privateList
    }
    fun filterTwoOrMore(): List<PackingItem>{
        return _privateList.filter { it.rating >= 2 }
    }

}

