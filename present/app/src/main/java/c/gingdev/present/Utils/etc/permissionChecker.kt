package c.gingdev.present.Utils.etc

import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.ActivityCompat

class permissionChecker(){
    private lateinit var mActivity: Activity
    private lateinit var mRPListener : RequestPermissionListener
    private var mRequsetCode = 1

    fun RequestPermission(mActivity: Activity, permissions : Array<String>, requestCode : Int, RPListener : RequestPermissionListener){
        this.mActivity = mActivity
        this.mRPListener = RPListener
        this.mRequsetCode = requestCode
        if(!needRequestPermission()){
            RPListener.onSuccess()
            return
        }
        requestUnGranted(permissions, requestCode)
    }

    private fun requestUnGranted(permissions: Array<String>, requestCode: Int){
        val permissions : Array<String> = findIsPermissionUnGranted(permissions)

        if(permissions.size == 0){
            mRPListener.onSuccess()
            return
        }
        return ActivityCompat.requestPermissions(mActivity, permissions, requestCode)
    }

    private fun findIsPermissionUnGranted(permissions: Array<String>) : Array<String>{
        var list:MutableList<String> = ArrayList()
        for(permission in permissions){
            if(!isPermissionGranted(permission)){
                list.add(permission)
            }
        }
        return list.toTypedArray()
    }

    private fun isPermissionGranted(permission : String) : Boolean{
        return ActivityCompat.checkSelfPermission(mActivity, permission) == PackageManager.PERMISSION_GRANTED
    }

    private fun needRequestPermission() : Boolean{
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    }

     fun requestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResult : IntArray){
        if(requestCode == mRequsetCode){
            if(grantResult.size > 0){
                for(gResult in grantResult){
                    if(gResult != PackageManager.PERMISSION_GRANTED){
                        mRPListener.onFailed()
                        return
                    }
                }
                mRPListener.onSuccess()
            }
            else{
                mRPListener.onFailed()
            }
        }
    }

    interface RequestPermissionListener{
        fun onSuccess()
        fun onFailed()
    }
}