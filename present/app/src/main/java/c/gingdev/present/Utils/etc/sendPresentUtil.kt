package c.gingdev.present.Utils.etc

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.provider.MediaStore
import android.util.Base64
import android.util.JsonWriter
import android.widget.ImageView
import androidx.core.graphics.drawable.toBitmap
import java.io.ByteArrayOutputStream
import java.io.File
import java.security.AccessControlContext

class sendPresntUtil{
    val imageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
    fun sendUtil(name : String, type : String, card : String, address : String, imageView: ImageView){
        val bitmap = getPictureUri(imageView)
        val json = "{\"sander\" : \"\n" + name + "\",\n\"name\" : \"" + name + "\",\n\"type\" : \"" + type + "\",\n\"card\" : \"" + card+"\"}"

    }

    fun getPictureUri(imageView: ImageView) : String {
    var bitmap = imageView.getDrawable().toBitmap()
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
        val imageBytes = baos.toByteArray()
        val encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT)
        return encodedImage
            //var bitmap  = data!!.extras!!.get("data")
////
//        var selectedImage: String = data!!.data.toString()
//        var uri = MediaStore.Images.Media.getContentUri(selectedImage)
//        var file = File(this.ex)
//        val uri: Uri = Uri.parse(selectedImage)
//        val s: Array<String> = arrayOf(MediaStore.Images.Media._ID)
//        val columnIndexID: Int
//        val listOfAllImages: MutableList<Uri> = mutableListOf()
//        val realUri = context.getContentResolver().query(uri, s, null, null, null)
//        var imageId: Long
//        if (realUri != null) {
//            columnIndexID = realUri.getColumnIndexOrThrow(MediaStore.Images.Media._ID)
//            while (realUri.moveToNext()) {
//                selectedImage = realUri.getString(columnIndexID)
//            }
//            realUri.close()
//        }
//        val path = selectedImage.substring(selectedImage.lastIndexOf("."), 1)
    }
}