package c.gingdev.dlab.main

import android.os.Bundle
import android.util.Log
import c.gingdev.dlab.R
import c.gingdev.dlab.base.BaseActivity
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : BaseActivity() {

	override fun layoutRes(): Int {
		return R.layout.activity_main
	}

	override fun onCreated(savedInstanceState: Bundle?) {
//		각종 코드
//		Log.i("retrofit", retrofit.toString())
	}
}
