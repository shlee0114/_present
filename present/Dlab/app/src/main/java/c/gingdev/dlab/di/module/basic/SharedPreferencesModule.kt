package c.gingdev.dlab.di.module.basic

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Provides
import javax.inject.Singleton

object SharedPreferencesModule {

    @Provides
    @Singleton
    fun providePref(app: Application): SharedPreferences {
        return app.getSharedPreferences("Preference", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePrefEditor(pref: SharedPreferences): SharedPreferences.Editor {
        return pref.edit()
    }
}