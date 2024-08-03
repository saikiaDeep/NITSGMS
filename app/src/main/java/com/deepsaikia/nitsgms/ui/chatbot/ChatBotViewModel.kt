package com.deepsaikia.nitsgms.ui.chatbot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ChatBotViewModel : ViewModel() {

    private val _items = MutableLiveData<List<String>>().apply {
        value = listOf("Item 1", "Item 2", "Item 3") // Initialize with some items
    }
    val items: LiveData<List<String>> = _items

    // Function to add a new item (for demonstration purposes)
    fun addItem(item: String) {
        val updatedList = _items.value.orEmpty() + item
        _items.value = updatedList
    }
}
