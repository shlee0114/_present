package c.gingdev.present.Utils

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {
		@GET("/")
		fun testConnection(): Call<JsonObject>
}