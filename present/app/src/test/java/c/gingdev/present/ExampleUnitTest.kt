package c.gingdev.present

import android.util.Log
import c.gingdev.present.Utils.RetrofitUtils
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

		@Test
		fun retrofiTest() {
				val retrofit = RetrofitUtils().getRetrofitService()

				retrofit.testConnection().doOnSuccess {
						Log.e("test", it.asString)
				}
		}
}
