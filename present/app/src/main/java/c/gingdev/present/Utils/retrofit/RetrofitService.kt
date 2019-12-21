package c.gingdev.present.Utils.retrofit

import c.gingdev.present.Model.presentData
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
		@GET("/")
		fun testConnection(): Call<JsonObject>

		@GET("/presents")
		fun getPresents(@Query("userId") userId: String): Call<List<presentData>>
}