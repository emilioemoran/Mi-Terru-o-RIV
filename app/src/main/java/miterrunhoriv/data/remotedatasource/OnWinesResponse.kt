package miterrunhoriv.data.remotedatasource

import miterrunhoriv.data.model.Wine

interface OnWinesResponse {

     fun getWines(wines: ArrayList<Wine>): ArrayList<Wine>{
        return wines
     }
}