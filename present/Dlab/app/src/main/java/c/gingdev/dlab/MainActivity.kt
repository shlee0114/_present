package c.gingdev.dlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import c.gingdev.dlab.base.BaseActivity

class MainActivity: BaseActivity() {

	override fun layoutRes(): Int {
		return R.layout.activity_main
	}

	override fun onCreated(savedInstanceState: Bundle?) {
//		각종 코드
	}
}
