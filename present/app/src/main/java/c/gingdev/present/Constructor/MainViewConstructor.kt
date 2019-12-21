package c.gingdev.present.Constructor

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

interface MainViewConstructor {
	interface View {
			fun responsePagerAdapter(adapter: FragmentStateAdapter)
	}
	interface Presenter {
			val view: View
			fun requirePagerAdpater(fm: FragmentManager, lifecycle: Lifecycle)
	}
}