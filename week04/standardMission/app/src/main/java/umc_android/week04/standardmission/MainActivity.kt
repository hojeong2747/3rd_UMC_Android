package umc_android.week04.standardmission

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import umc_android.week04.standardmission.databinding.ActivityMain2Binding
import umc_android.week04.standardmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private var memoData: String? = "" // String 타입 전역변수 선언

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root) // 화면 설정

        Log.d("Lifecycle", "onCreate")

        viewBinding.btnNext.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("text", viewBinding.etInput.text.toString())
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume")

        // 전역변수 내용으로 editText 내용 대체하기
        // 전역변수 값이 없는 상태라면 빈 editText
        if (memoData != null) {
            viewBinding.etInput.setText(memoData) // editText에 값 채워넣기
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Lifecycle", "onRestart")

        // Dialog 사용해보기
        // 다시 작성할 것인지 묻고 예, 아니오 버튼 누르게 하기
        // 예 -> onStop 저장한 전역변수 내용으로 editText 설정
        // 아니오 -> onStop 저장했던 변수 비우고 editText 비우기, 그럼 나중에 onResume 실행되니까 자동으로 실행 안 됨
        var builder = AlertDialog.Builder(this)
        builder.setTitle("메모 확인")
        builder.setMessage("메모를 재작성하시겠습니까?")
        builder.setIcon(R.mipmap.ic_launcher)

        // 버튼 클릭시에 무슨 작업을 할 것인가!
        builder.setPositiveButton("예") {
                dialogInterface: DialogInterface, i: Int ->
                memoData = "";
                viewBinding.etInput.setText("")    }

        builder.setNegativeButton("아니오") {
                dialogInterface: DialogInterface, i: Int ->
                viewBinding.etInput.setText(memoData)}

        builder.show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "onStop")

        // 전역변수에 현재까지 작성한 내용 담기
        memoData = viewBinding.etInput.text.toString()

        // 전역변수 저장 후 메모를 입력하는 editText는 비우기
        viewBinding.etInput.setText("")
    }

}