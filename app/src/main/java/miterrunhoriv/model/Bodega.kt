package miterrunhoriv.model

class Bodega(id:Long , nombre:String, vino: Array<Vino>) {
    var id: Long = 0
    var nombre: String =""
    var vino = emptyArray<Vino>()
}