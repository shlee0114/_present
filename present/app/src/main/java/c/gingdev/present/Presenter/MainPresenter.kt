package c.gingdev.present.Presenter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import c.gingdev.present.Constructor.MainViewConstructor
import c.gingdev.present.Utils.adapters.FragmentPagerAdapter
import c.gingdev.present.View.fragments.MainGetFragment
import c.gingdev.present.View.fragments.MainSendFragment
import c.gingdev.present.View.fragments.MainSettingFragment

class MainPresenter(override val view: MainViewConstructor.View)
		: MainViewConstructor.Presenter {
		override fun requirePagerAdpater(fm: FragmentManager, lifecycle: Lifecycle) {
				var adapter = FragmentPagerAdapter(fm, lifecycle)
						.apply {
						addItem(MainSendFragment())
						addItem(MainGetFragment())
						addItem(MainSettingFragment())
				}

				view.responsePagerAdapter(adapter)
		}
}