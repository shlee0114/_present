package c.gingdev.present.Presenter

import c.gingdev.present.Constructor.SplashViewConstructor
import c.gingdev.present.Utils.RetrofitService
import c.gingdev.present.Utils.RetrofitUtils
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashPresenter(override val view: SplashViewConstructor.View)
    : SplashViewConstructor.Presenter {


		private val retrofit: RetrofitService by lazy {
				RetrofitUtils().getRetrofitService()
		}

    override fun requestLoginType() {
        view.onLoginTypeResponse(SplashViewConstructor.LoginType.LOCAL)
    }
}