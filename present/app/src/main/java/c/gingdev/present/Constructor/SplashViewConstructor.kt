package c.gingdev.present.Constructor

interface SplashViewConstructor {
    enum class LoginType {
        KAKAO,
        LOCAL,
        NONE
    }
    interface View {
//        로그인타입 확인
        fun onLoginTypeResponse(loginType: LoginType)
    }
    interface Presenter {
        val view: View

        fun requestLoginType()
    }
}