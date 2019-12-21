package c.gingdev.present.Model

data class presentData(
		val _id: String,
		val files: List<file>,
		val sender: String,
		val name: String,
		val card: String,
		val type: String,
		val address: String,
		val getUser: String,
		val __v: Int,
		val accepted: String)

data class file(
		val fieldname: String,
		val originalname: String,
		val encoding: String,
		val mimetype: String,
		val destination: String,
		val filename: String,
		val path: String,
		val size: Int
)