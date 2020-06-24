package miterrunhoriv.data.repository

import android.util.Log
import android.widget.Toast
import miterrunhoriv.data.model.Wine
import miterrunhoriv.data.remotedatasource.MyApiAdapter
import miterrunhoriv.data.remotedatasource.WinesResponse
import miterrunhoriv.view.ui.BodegaActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WineDataSet {

    fun createWinesList(): List<Wine> {
        return getData()
    }
//        return listOf(
//            Wine(
//                1,
//                "BONARDA", "", "",
//                "962849300", "",
//                "Valle de Uco", 3, 5.5, "mtur"
//            ), Wine(
//                1,
//                "MALBEC", "", "",
//                "962849300", "",
//                "Valle de Uco", 3, 5.8, "mtesb"
//            ), Wine(
//                1,
//                "SYRA", "", "",
//                "962849300", "",
//                "Valle de Uco", 3, 5.8, "mtesb"
//            ), Wine(
//                1,
//                "PINOT NOIRE", "", "",
//                "962849300", "",
//                "Lujan de cuyo", 3, 5.8, "mtesb"
//            ), Wine(
//                1,
//                "MALBEC", "", "",
//                "962849300", "",
//                "Chile- Santiago", 3, 5.8, "mtecs"
//            )
//        )
//    }




    //obtiene datos de la api
fun getData():List<Wine> {
        var wineList: List<Wine> = listOf()
    val call: retrofit2.Call<WinesResponse> = MyApiAdapter.apiService!!.getWines()
    call.enqueue(object: Callback<WinesResponse>{
        override fun onFailure(call: Call<WinesResponse>, t: Throwable) {
            // Toast.makeText(context, t.localizedMessage, Toast.LENGTH_SHORT).show()
            Log.d("TAG", "aca fallo")
        }

        override fun onResponse(
            call: Call<WinesResponse>,
            response: Response<WinesResponse>
        ) {
            if (response.isSuccessful){
                var wineResponse : WinesResponse? = response.body()
                if (wineResponse != null) {
                    wineList = wineResponse.data
                    Log.d("TAG", "Va bien")

                }
            }else{
                Toast.makeText(BodegaActivity(),"error en el formato",Toast.LENGTH_SHORT).show()
            }
        }
    })
        return wineList
    }
}
///////////////////
//    inner class WinesCallBack(): retrofit2.Callback <WinesResponse> {
//        var wineList: List<Wine>? = null
//        override fun onFailure(call: retrofit2.Call<WinesResponse>, t: Throwable) {
//            // Toast.makeText(context, t.localizedMessage, Toast.LENGTH_SHORT).show()
//            Log.d("TAG", "aca fallo")
//        }
//
//        override fun onResponse(
//            call: Call<WinesResponse>,
//            response: Response<WinesResponse>
//        ) {
//            if (response.isSuccessful){
//                var wineResponse : WinesResponse? = response.body()
//                if (wineResponse != null) {
//                    WineDataSet().wineList = wineResponse.data
//
//                }
//            }else{
//                 Toast.makeText(BodegaActivity(),"error en el formato",Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//    }