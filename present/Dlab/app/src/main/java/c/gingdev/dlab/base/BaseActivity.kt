package c.gingdev.dlab.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity: DaggerAppCompatActivity() {

    @LayoutRes
    protected abstract fun layoutRes(): Int

//    기본 injection 및 액티비티 기
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
    
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())

        onCreated(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    protected abstract fun onCreated(savedInstanceState: Bundle?)
}