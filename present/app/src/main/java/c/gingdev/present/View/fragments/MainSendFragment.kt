package c.gingdev.present.View.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import c.gingdev.present.Model.permissionModels
import c.gingdev.present.R
import c.gingdev.present.Utils.etc.permissionChecker
import c.gingdev.present.Utils.etc.sendPresntUtil
import c.gingdev.present.View.MainActivity

class MainSendFragment: Fragment() {

		override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
			val inflater = inflater.inflate(R.layout.fragment_send, container, false)
			val btnInsertImage = inflater.findViewById<Button>(R.id.addPic)
            btnInsertImage.setOnClickListener{
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                startActivityForResult(intent,
                    1
                )

            }
				return inflater

		}
    var imageView: ImageView? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        imageView!!.setImageURI(data!!.data)
        val sent = sendPresntUtil()
    }

		override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
				super.onViewCreated(view, savedInstanceState)

		}
}