package miterrunhoriv.services.db

import android.telecom.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import miterrunhoriv.services.db.WinesResponse


interface MyApiService {
    @GET("wines/")
    fun getWines(): retrofit2.Call<WinesResponse>

}