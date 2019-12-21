package c.gingdev.present.Utils.retrofit

class RetrofitUtils {
		var baseUrl: String = "http://192.168.211.113:4000"

		private val retrofit by lazy {
			RetrofitInjection.provideRetrofit(baseUrl)
		}

		fun getRetrofitService(): RetrofitService {
				return retrofit.create(RetrofitService::class.java)
		}
}