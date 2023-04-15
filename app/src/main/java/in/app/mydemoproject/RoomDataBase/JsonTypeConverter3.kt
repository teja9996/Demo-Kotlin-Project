package `in`.app.mydemoproject.RoomDataBase

import androidx.room.TypeConverter
import com.google.gson.Gson

class JsonTypeConverter3 {

    @TypeConverter
    fun fromJson(json: String): MyJsonObject3 {
        return Gson().fromJson(json, MyJsonObject3::class.java)
    }

    @TypeConverter
    fun toJson(obj: MyJsonObject3?): String? {
        return Gson().toJson(obj)
    }
}
