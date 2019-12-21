package c.gingdev.present.Constructor

import androidx.recyclerview.widget.RecyclerView
import c.gingdev.present.Utils.adapters.PresentPagerHolder

interface GetViewConstructor {
		interface View {
			fun dataResponsed(adapter: RecyclerView.Adapter<PresentPagerHolder>)
		}
		interface Presenter {
			val view: View
			fun requireViewPagerWithDatas()
		}
}