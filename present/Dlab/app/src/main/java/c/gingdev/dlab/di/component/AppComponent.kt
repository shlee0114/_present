package c.gingdev.dlab.di.component

import android.app.Application
import c.gingdev.dlab.base.App
import c.gingdev.dlab.di.module.basic.AppModule
import c.gingdev.dlab.di.module.network.NetworkModule
import c.gingdev.dlab.di.module.view.ActivityBindingModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    AndroidSupportInjectionModule::class,
    ActivityBindingModule::class])
interface AppComponent: AndroidInjector<DaggerApplication> {

    fun inject(app: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }
}