package miterrunhoriv.view

import miterrunhoriv.data.model.Wine
import java.util.*

class VinosVector: Vinos {
 private var vectorVinos: MutableList<Wine> = ejemploVinos()

    fun VinosVector() {
        vectorVinos = ejemploVinos()
    }
    override fun elemento(id: Int): Wine {
        return vectorVinos.get(id)
    }
    override fun tamanyo(): Int {
        return vectorVinos.size
    }

    fun actualiza(id: Int, vino: Wine) {
        vectorVinos.set(id, vino)
    }

    fun ejemploVinos(): ArrayList<Wine> {
        val vinos: ArrayList<Wine> = ArrayList<Wine>()
        vinos.add(
            Wine(
                1,
                "CAVERNET SAUVIGNION", "", "",
                "962849300", "",
                "Valle de Uco", 3, 5.5, "mtur"
            )
        )
        vinos.add(
            Wine(
                1,
                "MALBEC", "", "",
                "962849300", "",
                "Valle de Uco", 3, 5.8, "mtesb"
            )
        )
        vinos.add(
            Wine(
                1,
                "SYRA", "", "",
                "962849300", "",
                "Valle de Uco", 3, 5.8, "mtesb"
            )
        )
        vinos.add(
            Wine(
                1,
                "PINOT NOIRE", "", "",
                "962849300", "",
                "Lujan de cuyo", 3, 5.8, "mtesb"
            )
        )
        vinos.add(
            Wine(
                1,
                "MALBEC", "", "",
                "962849300", "",
                "Chile- Santiago", 3, 5.8, "mtecs"
            )
        )
        return vinos
    }
}
