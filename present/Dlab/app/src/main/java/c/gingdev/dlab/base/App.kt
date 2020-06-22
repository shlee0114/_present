package c.gingdev.dlab.base

import c.gingdev.dlab.di.component.AppComponent
import c.gingdev.dlab.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component: AppComponent =
            DaggerAppComponent
                .builder()
                .application(this)
                .build()

        component.inject(this)

        return component
    }
}