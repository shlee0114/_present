package c.gingdev.present.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import c.gingdev.present.R
import c.gingdev.present.Utils.etc.checkBackgroundColor
import c.gingdev.present.Utils.etc.getStatusBarHeight
import c.gingdev.present.Utils.etc.statusBarTransparent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

				initStatusBar()
    }

		private fun initStatusBar() {
				statusBarTransparent()
				statusBar.layoutParams.height = getStatusBarHeight()
				checkBackgroundColor(background)
		}

}
