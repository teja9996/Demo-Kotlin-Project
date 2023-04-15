package `in`.app.mydemoproject.RoomDataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [MyEntity::class], version = 1)
@TypeConverters(JsonTypeConverter::class, JsonTypeConverter2::class, JsonTypeConverter3::class)

abstract class MyDatabaseNew : RoomDatabase() {
    // ... Room database definition ...
    abstract fun myDao(): MyDaoo


    companion object {
        @Volatile
        private var INSTANCE: MyDatabaseNew? = null

        fun getInstance(context: Context): MyDatabaseNew {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabaseNew::class.java,
                    "my_db"
                )
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}