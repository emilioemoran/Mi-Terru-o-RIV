package miterrunhoriv.data.remotedatasource

import retrofit2.http.GET


interface MyApiService {
    @GET("wines/")
    fun getWines(): retrofit2.Call<WinesResponse>

}