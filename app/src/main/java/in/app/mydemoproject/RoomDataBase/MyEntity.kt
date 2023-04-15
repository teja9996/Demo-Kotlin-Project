package `in`.app.mydemoproject.RoomDataBase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "my_table")
data class MyEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "json_data") val jsonData: MyJsonObject ,
    @ColumnInfo(name = "json_data2") val jsonData2: MyJsonObject2 ,
    @ColumnInfo(name = "json_data3") val jsonData3: MyJsonObject3
)
