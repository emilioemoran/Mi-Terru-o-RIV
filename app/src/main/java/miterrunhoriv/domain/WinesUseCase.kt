package miterrunhoriv.domain

import miterrunhoriv.data.model.Wine
import miterrunhoriv.data.remotedatasource.OnWinesResponse
import miterrunhoriv.data.repository.WineDataSet
import miterrunhoriv.view.ui.BodegaActivity
import miterrunhoriv.view.viewmodel.BodegaViewModel

class WinesUseCase {
    private val wineDataSet = WineDataSet()

//    fun getWineList() :ArrayList<Wine>{
//        var wines: ArrayList<Wine> = arrayListOf()
//        wineDataSet.createWinesList(object : OnWinesResponse {
//            override fun getWines(dwines: ArrayList<Wine>): ArrayList<Wine> {
//                BodegaViewModel().postWineListLiveData(dwines)
//                return dwines
//            }
//        })
//        return wines
//    }
}