package com.example.grocerify.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.grocerify.data.db.entities.ShoppingItem

@Database(
    entities = [ShoppingItem::class],
    version = 1
)
abstract class ShoppingDatabase: RoomDatabase() {
    abstract fun getShoppingDao() : ShoppingDao

    companion object {
        @Volatile
        private var instance: ShoppingDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) { // called every time we create an instance of shopping db
            instance ?: createDatabase(context).also { instance = it } // instance is null, we create db, and set instance of result of createDabase
        }

        private fun createDatabase(context: Context) = // creates database for shopping items
            Room.databaseBuilder(context.applicationContext,
            ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}