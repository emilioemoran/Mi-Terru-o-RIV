package miterrunhoriv.view


import miterrunhoriv.model.Wine

interface Vinos {
   fun elemento(id: Int):Wine
    fun tamanyo(): Int
}