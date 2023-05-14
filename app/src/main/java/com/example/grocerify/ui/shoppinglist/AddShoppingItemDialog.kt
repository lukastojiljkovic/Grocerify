package com.example.grocerify.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.grocerify.R
import com.example.grocerify.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.etAmount
import kotlinx.android.synthetic.main.dialog_add_shopping_item.etName
import kotlinx.android.synthetic.main.dialog_add_shopping_item.tvAdd
import kotlinx.android.synthetic.main.dialog_add_shopping_item.tvCancel

class AddShoppingItemDialog(context: Context, var addDialogListener: AddDialogListener) : AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()) {
                Toast.makeText(context, "Please enter all info", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }

}