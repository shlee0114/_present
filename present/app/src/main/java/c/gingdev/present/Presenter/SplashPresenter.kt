package c.gingdev.present.Presenter

import c.gingdev.present.Constructor.SplashViewConstructor

class SplashPresenter(override val view: SplashViewConstructor.View)
    : SplashViewConstructor.Presenter {


    override fun requestLoginType() {
        view.onLoginTypeResponse(SplashViewConstructor.LoginType.LOCAL)
    }
}