package c.gingdev.present.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.adapter.FragmentStateAdapter
import c.gingdev.present.Constructor.MainViewConstructor
import c.gingdev.present.Presenter.MainPresenter
import c.gingdev.present.R
import c.gingdev.present.Utils.etc.checkBackgroundColor
import c.gingdev.present.Utils.etc.getStatusBarHeight
import c.gingdev.present.Utils.etc.statusBarTransparent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainViewConstructor.View {

	private val presenter by lazy {
				MainPresenter(this)
		}

//    onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

				initStatusBar()
				initViewPager()
    }

		private fun initStatusBar() {
				statusBarTransparent()
				statusBar.layoutParams.height = getStatusBarHeight()
				checkBackgroundColor(background)
		}

		private fun initViewPager() {
				presenter.requirePagerAdpater(supportFragmentManager, lifecycle)

				bottomNav.setOnNavigationItemSelectedListener {
					when(it.itemId) {
						R.id.send_present -> {
							pager.setCurrentItem(0, true)
						}
						R.id.get_present -> {
							pager.setCurrentItem(1, true)
						}
						R.id.setting -> {
							pager.setCurrentItem(2, true)
						}
					}

					true
				}
		}

		override fun responsePagerAdapter(adapter: FragmentStateAdapter) {
				pager.adapter = adapter
				pager.isUserInputEnabled = false
		}
}
