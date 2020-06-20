package miterrunhoriv

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import miterrunhoriv.model.Bodega
import miterrunhoriv.view.AdaptadorVinos
import miterrunhoriv.view.Vinos
import miterrunhoriv.view.VinosVector

class BodegaActivity : AppCompatActivity() {

    private lateinit var bodega: String
    var vinos: Vinos = VinosVector()
    private lateinit var recyclerView: RecyclerView
    lateinit var adaptador: AdaptadorVinos
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bodega_vinos)
        val extras = intent.extras
        if (extras != null) {
            bodega = extras.getString("Bodega","")
        }

        recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        adaptador = AdaptadorVinos(this, vinos)
        recyclerView.adapter = adaptador
        layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = layoutManager
}
}