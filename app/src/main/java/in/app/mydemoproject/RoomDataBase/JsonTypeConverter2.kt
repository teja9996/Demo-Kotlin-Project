package `in`.app.mydemoproject.RoomDataBase

import androidx.room.TypeConverter
import com.google.gson.Gson

class JsonTypeConverter2 {

    @TypeConverter
    fun fromJson(json: String): MyJsonObject2? {
        return Gson().fromJson(json, MyJsonObject2::class.java)
    }

    @TypeConverter
    fun toJson(obj: MyJsonObject2?): String? {
        return Gson().toJson(obj)
    }
}
