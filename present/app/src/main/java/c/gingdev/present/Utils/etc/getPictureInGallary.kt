package c.gingdev.present.Utils.etc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

class getPictureInGallary : AppCompatActivity() {


     fun openGallery(intent: Intent){
    }

    companion object {
        //image pick code
        private val IMAGE_PICK_CODE = 1000
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    }
}
