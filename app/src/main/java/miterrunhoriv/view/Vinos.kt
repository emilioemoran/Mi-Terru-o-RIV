package miterrunhoriv.view


import miterrunhoriv.data.model.Wine

interface Vinos {
   fun elemento(id: Int): Wine
    fun tamanyo(): Int
}