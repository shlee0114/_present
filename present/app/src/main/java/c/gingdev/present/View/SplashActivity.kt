package c.gingdev.present.View

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import c.gingdev.present.Constructor.SplashViewConstructor
import c.gingdev.present.Presenter.SplashPresenter
import c.gingdev.present.R

class SplashActivity: AppCompatActivity(), SplashViewConstructor.View {
    //    prestener 생성 by lazy
    private val presenter by lazy {
        SplashPresenter(this)
    }

//    onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        presenter.requestLoginType()
    }

    override fun onLoginTypeResponse(loginType: SplashViewConstructor.LoginType) {
        var str: String = ""
        when(loginType) {
            SplashViewConstructor.LoginType.KAKAO -> {
//                카카오로그인일시
                str = "kakao"
            }
            SplashViewConstructor.LoginType.LOCAL -> {
//                로컬 로그인일시
                str = "local"
            }
            SplashViewConstructor.LoginType.NONE -> {
//                로그인해야할경우
                str = "none"
            }
        }

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }
}