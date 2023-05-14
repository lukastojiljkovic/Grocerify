package com.example.grocerify.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.grocerify.data.db.entities.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)  // mix of update and insert

    @Delete
    suspend fun delete(item: ShoppingItem)  // deletes item

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItems() : LiveData<List<ShoppingItem>>  // gets all items

}