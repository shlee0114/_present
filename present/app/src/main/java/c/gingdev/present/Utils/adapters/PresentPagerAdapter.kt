package c.gingdev.present.Utils.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import c.gingdev.present.Model.file
import c.gingdev.present.Model.presentData
import c.gingdev.present.R
import c.gingdev.present.Utils.retrofit.RetrofitUtils
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_get_item.view.*

class PresentPagerAdapter(private val list: List<presentData>): RecyclerView.Adapter<PresentPagerHolder>() {
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PresentPagerHolder {
		return PresentPagerHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_get_item, parent, false))
	}

	override fun getItemCount(): Int {
			return list.size
	}

	override fun onBindViewHolder(holder: PresentPagerHolder, position: Int) {
			holder.bind(list[position])
	}
}

class PresentPagerHolder(private val view: View): RecyclerView.ViewHolder(view) {
	fun bind(data: presentData) {
		view.titleText.text = data.name
		view.contentText.text = data.card

		Glide.with(view.context)
				.load("${RetrofitUtils().baseUrl}/presents/files?presentId=${data._id}")
				.into(view.image)
	}
}