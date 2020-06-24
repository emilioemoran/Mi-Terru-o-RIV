package miterrunhoriv.data.remotedatasource

import miterrunhoriv.data.model.Wine

class WinesResponse(){

   lateinit var data: List<Wine>

   fun wineList(list: List<Wine>){}

}