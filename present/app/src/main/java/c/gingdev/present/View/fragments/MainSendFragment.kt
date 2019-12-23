package c.gingdev.present.View.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.transition.Visibility
import c.gingdev.present.Model.permissionModels
import c.gingdev.present.R
import c.gingdev.present.Utils.etc.permissionChecker
import c.gingdev.present.Utils.etc.sendPresntUtil
import c.gingdev.present.View.MainActivity

class MainSendFragment: Fragment() {

    var imageView: ImageView? = null
    var picture:LinearLayout? = null
		override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
			val inflater = inflater.inflate(R.layout.fragment_send, container, false)
			val btnInsertImage = inflater.findViewById<Button>(R.id.addPic)
            val btnNextLv = inflater.findViewById<Button>(R.id.nextLv)
            val editName = inflater.findViewById<EditText>(R.id.name)
            val editCard = inflater.findViewById<EditText>(R.id.sendText)
            val btnCancel = inflater.findViewById<Button>(R.id.btnCancle)
            picture = inflater.findViewById(R.id.picture)

            btnCancel.setOnClickListener{
                picture!!.visibility = View.GONE
            }

            btnNextLv.setOnClickListener{
                val send = sendPresntUtil()
                send.sendUtil(editName.toString(),"picture",editCard.toString(),"", imageView!!)
            }

            btnInsertImage.setOnClickListener{
                val intent = Intent(Intent.ACTION_PICK)
                intent.type = "image/*"
                startActivityForResult(intent,
                    1
                )

            }
				return inflater

		}

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        imageView!!.setImageURI(data!!.data)
        picture!!.visibility =View.VISIBLE
    }

		override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
				super.onViewCreated(view, savedInstanceState)

		}
}