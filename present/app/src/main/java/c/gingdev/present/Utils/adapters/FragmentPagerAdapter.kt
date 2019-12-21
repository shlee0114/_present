package c.gingdev.present.Utils.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPagerAdapter(fm: FragmentManager, lifecycle: Lifecycle)
		: FragmentStateAdapter(fm, lifecycle) {
		private var fragmentList: ArrayList<Fragment> = ArrayList()
		override fun getItemCount(): Int {
				return fragmentList.size
		}

		override fun createFragment(position: Int): Fragment {
				return fragmentList[position]
		}

		fun addItem(fragment: Fragment) {
				fragmentList.add(fragment)
		}
}