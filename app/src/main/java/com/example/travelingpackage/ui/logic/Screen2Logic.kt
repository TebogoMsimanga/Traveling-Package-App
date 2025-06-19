package com.example.travelingpackage.ui.logic

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel(){
    private val _privateList = mutableStateListOf<PackingItem>()

    val packingList: List<PackingItem> get() = _privateList

    init {
        _privateList.add(PackingItem("Residual", "Chris Brown", 3, "Favourite"))
        _privateList.add(PackingItem("Love me", "Justin Bieber", 5, "dance music"))
        _privateList.add(PackingItem("Burn", "Usher", 1, "Sad song"))
        _privateList.add(PackingItem("Run this world", "Rihanna", 5, "fun song"))
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

