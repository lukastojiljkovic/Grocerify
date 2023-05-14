package com.example.grocerify.ui.shoppinglist

import com.example.grocerify.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}