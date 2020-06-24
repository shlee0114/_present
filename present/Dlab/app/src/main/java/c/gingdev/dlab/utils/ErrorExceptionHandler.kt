package c.gingdev.dlab.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import c.gingdev.dlab.base.BaseActivityLifecycleCallbacks
import c.gingdev.dlab.main.ErrorActivity

class ErrorExceptionHandler (
    app: Application,
    private val defaultExceptionHandler: Thread.UncaughtExceptionHandler,
    private val fabricExceptionHandler: Thread.UncaughtExceptionHandler
): Thread.UncaughtExceptionHandler {
    //    마지막 액티비티와 현재 에러가 일어나있는 액티비티 갯수
    private var lastActivity: Activity? = null
    private var activityCnt = 0

    init {
        app.registerActivityLifecycleCallbacks(object: BaseActivityLifecycleCallbacks() {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                if (activity.isSkipActivity()) {
                    return
                }
                lastActivity = activity
            }
        })
    }

    private fun Activity.isSkipActivity() = this is ErrorActivity

    override fun uncaughtException(thread: Thread, throwable: Throwable) {

    }
}