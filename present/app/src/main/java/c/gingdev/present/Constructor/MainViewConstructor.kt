package c.gingdev.present.Constructor

interface MainViewConstructor {
	interface View {
			fun responsePagerAdapter()
	}
	interface Presenter {
			val view: View
			fun requirePagerAdpater()
	}
}