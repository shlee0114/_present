package c.gingdev.dlab.di.module.basic

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {
    @Binds
    abstract fun provideApp(app: Application): Context
}