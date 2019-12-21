package c.gingdev.present.Presenter

import c.gingdev.present.Constructor.SplashViewConstructor
import c.gingdev.present.Utils.retrofit.RetrofitService
import c.gingdev.present.Utils.retrofit.RetrofitUtils

class SplashPresenter(override val view: SplashViewConstructor.View)
    : SplashViewConstructor.Presenter {

    override fun requestLoginType() {
        view.onLoginTypeResponse(SplashViewConstructor.LoginType.NONE)
    }
}