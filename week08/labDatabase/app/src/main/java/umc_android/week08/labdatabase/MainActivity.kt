package umc_android.week08.labdatabase

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import umc_android.week08.labdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        val roomDb = AppDatabase.getInstance(this)

        if (roomDb != null) {
            val deletedUser = User("", 0,1)
            roomDb.userDao().delete(deletedUser)

            val user = User("에이치", 23)
            roomDb.userDao().insert(user)

            val userList = roomDb.userDao().selectAll()
            Log.d("DB", "User List: ${userList}")

            val user2 = roomDb.userDao().selectByUserId(2)
            Log.d("DB", "User id 2 : $user")
        }


////         실습1
//         변수 생성 (지금은 activity라서 바로 get으로 가져올 수 있는데 fragment라면 context를 앞에 붙여야함)
//         name은 앱 내부적으로 관리되는 sharedPreference(xml파일) 을 패키지 명으로 가져오거나, 임의로 적으면 됨
//         Context.MODE_PRIVATE는 항상 이거 써서 걍 알면 됨
//        val sharedPrefs = getSharedPreferences("sharedprefs", Context.MODE_PRIVATE)
//        val editor = sharedPrefs.edit()
//
//        // 이 코드는 무시(초기화용)
//        // editor를 이용해 값을 넣을 수 있음 (수정 가능)
//        editor.putString("H", "")
//        editor.apply()
//
//        // 1. pusString만 하고 apply 안 했을 때 -> 아무 값도 안 나와야 함
//        editor.putString("H", "android")
//        // 값을 가져올 수 있음. 두번째 인자에는 값이 없을 때 어떤 값으로 할 건지 적으면 됨.
//        val beforeApplyValue = sharedPrefs.getString("H", "")
//        Log.d("SP Before", "${beforeApplyValue}")
//
//        // 2. pusString만 하고 apply 했을 때 -> sharedPrefs에 값이 들어감
//        editor.apply()
//        val spValue = sharedPrefs.getString("H", "")
//        Log.d("SP", "${spValue}")
    }
}