package c.gingdev.dlab.di.module.view

import c.gingdev.dlab.main.ErrorActivity
import c.gingdev.dlab.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindErrorActivity(): ErrorActivity
}