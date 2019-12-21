package c.gingdev.present.View

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import c.gingdev.present.Constructor.SplashViewConstructor
import c.gingdev.present.Presenter.SplashPresenter
import c.gingdev.present.R
import kotlin.concurrent.thread
import androidx.core.os.HandlerCompat.postDelayed

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.os.Handler
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

class SplashActivity: AppCompatActivity(), SplashViewConstructor.View {
    //    prestener 생성 by lazy
    private val presenter by lazy {
        SplashPresenter(this)
    }

//    onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            this.finish()
        },1000)
    }

    override fun onLoginTypeResponse(loginType: SplashViewConstructor.LoginType) {
        var str: String = ""
	      var intent: Intent? = null
        when(loginType) {
            SplashViewConstructor.LoginType.KAKAO -> {
//                카카오로그인일시
            }
            SplashViewConstructor.LoginType.LOCAL -> {
//                로컬 로그인일시
            }
            SplashViewConstructor.LoginType.NONE -> {
//                로그인해야할경우
	              intent = Intent(this, MainActivity::class.java)
            }
        }
        startActivity(intent!!)
    }
}