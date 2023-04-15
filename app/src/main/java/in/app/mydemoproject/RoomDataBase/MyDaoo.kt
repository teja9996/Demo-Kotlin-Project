package `in`.app.mydemoproject.RoomDataBase


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MyDaoo  {

    // Insert an entity with JSON objects
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMyEntity(entity: MyEntity)

    // Insert multiple entities with JSON objects
    @Insert
    fun insertMyEntities(entities: List<MyEntity>)

    @Query("SELECT * FROM my_table")
    fun getAllEntities(): List<MyEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: MyEntity)

    @Query("SELECT * FROM my_table")
    fun getAllJsonObjects(): List<MyEntity?>?


    @Query("SELECT * FROM my_table WHERE id = :id")
    suspend fun getObjectId(id: Int): MyEntity?
}