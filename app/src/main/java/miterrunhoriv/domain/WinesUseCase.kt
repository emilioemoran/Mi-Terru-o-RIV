package miterrunhoriv.domain

import miterrunhoriv.data.model.Wine
import miterrunhoriv.data.repository.WineDataSet

class WinesUseCase {
    private val wineDataSet = WineDataSet()

    fun getWineList() :List<Wine>{
        return wineDataSet.createWinesList()
    }

}