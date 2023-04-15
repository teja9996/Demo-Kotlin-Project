package `in`.app.mydemoproject.RoomDataBase

import androidx.room.TypeConverter
import com.google.gson.Gson

class JsonTypeConverter {

    @TypeConverter
    fun fromJson(json: String): MyJsonObject? {
        return Gson().fromJson(json, MyJsonObject::class.java)
    }

    @TypeConverter
    fun toJson(obj: MyJsonObject?): String? {
        return Gson().toJson(obj)
    }
}
