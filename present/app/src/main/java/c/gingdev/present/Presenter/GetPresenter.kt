package c.gingdev.present.Presenter

import android.util.Log
import androidx.viewpager2.adapter.FragmentStateAdapter
import c.gingdev.present.Constructor.GetViewConstructor
import c.gingdev.present.Model.file
import c.gingdev.present.Model.presentData
import c.gingdev.present.Utils.adapters.PresentPagerAdapter
import c.gingdev.present.Utils.etc.prefUtils
import c.gingdev.present.Utils.retrofit.RetrofitService
import c.gingdev.present.Utils.retrofit.RetrofitUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPresenter(override val view: GetViewConstructor.View)
		: GetViewConstructor.Presenter {

	private val retrofit: RetrofitService by lazy {
				RetrofitUtils().getRetrofitService()
		}

	var data: List<presentData>? = null
	override fun requireViewPagerWithDatas() {
				retrofit.getPresents(prefUtils.user2)
						.enqueue(object: Callback<List<presentData>> {
							override fun onFailure(call: Call<List<presentData>>, t: Throwable) {
									Log.e("it","failed!!")
							}

							override fun onResponse(call: Call<List<presentData>>, response: Response<List<presentData>>) {
									Log.e("data", "${response.body()}")
									data = response.body()

									data?.run {
										setAdapterWithData(this)
									}
							}
						})
	}

	private fun setAdapterWithData(list: List<presentData>) {
		val adapter = PresentPagerAdapter(list)

		view.dataResponsed(adapter)
	}
}