package c.gingdev.present.View.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import c.gingdev.present.Constructor.GetViewConstructor
import c.gingdev.present.Presenter.GetPresenter
import c.gingdev.present.R
import c.gingdev.present.Utils.adapters.PresentPagerHolder
import kotlinx.android.synthetic.main.fragment_get.*

class MainGetFragment: Fragment(), GetViewConstructor.View {
	private val presenter by lazy {
				GetPresenter(this)
		}

		override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
				return inflater.inflate(R.layout.fragment_get, container, false)
		}

		override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
				super.onViewCreated(view, savedInstanceState)

				presenter.requireViewPagerWithDatas()
		}

		override fun dataResponsed(adapter: RecyclerView.Adapter<PresentPagerHolder>) {
			getPager.adapter = adapter
		}
}