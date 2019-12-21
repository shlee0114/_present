package c.gingdev.present.Presenter

import c.gingdev.present.Constructor.MainViewConstructor

class MainPresenter(override val view: MainViewConstructor.View)
		: MainViewConstructor.Presenter {
		override fun requirePagerAdpater() {

		}
}