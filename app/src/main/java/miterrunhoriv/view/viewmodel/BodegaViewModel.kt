package miterrunhoriv.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import miterrunhoriv.data.model.Wine
import miterrunhoriv.domain.WinesUseCase

class BodegaViewModel : ViewModel() {
//     var wines: ArrayList<Wine>?=null

    val wineUseCase = WinesUseCase()
    private val listData = MutableLiveData<List<Wine>>()

    init {
        getWineList()
    }

    fun setListData(listWines: List<Wine>){
        listData.value = listWines
    }

    fun getWineList(){
        setListData(wineUseCase.getWineList())
    }

    fun getWineListLiveData(): LiveData<List<Wine>>{
        return listData
    }


//    //obtiene datos de la api
//    fun obtenerdatos(){
//    val call: retrofit2.Call<WinesResponse> = MyApiAdapter.apiService!!.getWines()
//    call.enqueue(WinesCallBack())
//    }


//inner class WinesCallBack(): retrofit2.Callback <WinesResponse> {
//
//    override fun onFailure(call: retrofit2.Call<WinesResponse>, t: Throwable) {
//        // Toast.makeText(context, t.localizedMessage, Toast.LENGTH_SHORT).show()
//        Log.d("TAG", "aca fallo")
//    }
//
//    override fun onResponse(
//        call: Call<WinesResponse>,
//        response: Response<WinesResponse>
//    ) {
//        if (response.isSuccessful){
//            var wineResponse : WinesResponse? = response.body()
//            if (wineResponse != null) {
//                var wines: ArrayList<Wine> = wineResponse.data
//                BodegaViewModel().wines = wines
//            }
//        }else{
//             Toast.makeText(BodegaActivity(),"error en el formato",Toast.LENGTH_SHORT).show()
//        }
//    }
//}

}
