package umc_android.week09.labretrofit

//import android.telecom.Call
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("app/users/email-check")
    fun getCheckEmail(
        @Query("email") email: String
    ): Call<Response>

}