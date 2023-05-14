package com.example.grocerify.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerify.R
import com.example.grocerify.data.db.entities.ShoppingItem
import com.example.grocerify.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.ivDelete
import kotlinx.android.synthetic.main.shopping_item.view.ivMinus
import kotlinx.android.synthetic.main.shopping_item.view.ivPlus
import kotlinx.android.synthetic.main.shopping_item.view.tvAmount
import kotlinx.android.synthetic.main.shopping_item.view.tvName

class ShoppingItemAdapter(
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
): RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }
    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currShoppingItem = items[position]
        holder.itemView.tvName.text = currShoppingItem.name
        holder.itemView.tvAmount.text = "${currShoppingItem.amount}"

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(currShoppingItem)
        }

        holder.itemView.ivPlus.setOnClickListener {
            currShoppingItem.amount++
            viewModel.upsert(currShoppingItem)
        }

        holder.itemView.ivMinus.setOnClickListener {
            if(currShoppingItem.amount > 0) {
                currShoppingItem.amount--
                viewModel.upsert(currShoppingItem)
            }
        }

    }

    override fun getItemCount (): Int {
        return items.size
    }

    inner class ShoppingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}