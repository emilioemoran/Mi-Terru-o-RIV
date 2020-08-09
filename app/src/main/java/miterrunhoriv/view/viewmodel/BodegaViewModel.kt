package miterrunhoriv.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import miterrunhoriv.data.model.Wine
import miterrunhoriv.data.remotedatasource.OnWinesResponse
import miterrunhoriv.data.repository.WineDataSet
import miterrunhoriv.domain.WinesUseCase

class BodegaViewModel : ViewModel() {


    val wineDataSet = WineDataSet()
    private val listData = MutableLiveData<ArrayList<Wine>>()

//   init {
//      getWineList()
//    }

    fun setListData(listWines: ArrayList<Wine>){
        listData.value = listWines
    }

    fun getWineList(){
        var wines: ArrayList<Wine> = arrayListOf()
        wineDataSet.createWinesList(object : OnWinesResponse {
            override fun getWines(dwines: ArrayList<Wine>): ArrayList<Wine> {
                // Filtramos los elementos que no tienen nombre
                var j : Int = 0
                for (i in dwines){
                    if (i.name != ""){
                        wines.add(j , i)
                        j ++
                    }
                }
                setListData(wines)
                return wines
            }
        })
    }

    fun getWineListLiveData(): LiveData<ArrayList<Wine>>{
        return listData
    }

    fun postWineListLiveData(listWines: ArrayList<Wine>){
        return listData.postValue(listWines)
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
