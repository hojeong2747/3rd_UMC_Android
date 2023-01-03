package umc_android.week09.labretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 웹브라우저 창 열기
        val retrofit = Retrofit.Builder()
            .baseUrl("https://prodmp.eric-rc.shop/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // 주소 입력
        val apiService = retrofit.create(ApiService::class.java)
        // 입력 주소 중에 하나로 연결 시도
        apiService.getCheckEmail("hojeong2747@naver.com").enqueue(object : Callback<Response> {
            override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
               if (response.isSuccessful) {
                   val responseData = response.body()

                   if(responseData != null)
                       Log.d("Retrofit","Response\n${responseData.code} Message\n" +
                               "${responseData.message}")
                   else {
                       Log.e("Retrofit", "Response Not Successful ${response.code()}")
                   }
               }

            }

            override fun onFailure(call: Call<Response>, t: Throwable) {
                Log.e("Retrofit", "Error", t)
            }
        })
    }
}