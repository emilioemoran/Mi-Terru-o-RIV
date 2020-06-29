package miterrunhoriv.view.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import miterrunhoriv.R
import miterrunhoriv.data.model.Wine
import miterrunhoriv.view.AdaptadorVinos
import miterrunhoriv.view.viewmodel.BodegaViewModel
import miterrunhoriv.view.Vinos
import miterrunhoriv.view.VinosVector

class BodegaActivity : AppCompatActivity() {

    private lateinit var bodega: String
//    var vinos: Vinos = VinosVector()
    private lateinit var recyclerView: RecyclerView
    lateinit var adaptador: AdaptadorVinos
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var bodegaViewModel:BodegaViewModel
//    private lateinit var wineList: List<Wine>



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bodega_vinos)
        val extras = intent.extras
        if (extras != null) {
            bodega = extras.getString("Bodega","")
        }

        bodegaViewModel = ViewModelProvider(this).get(BodegaViewModel::class.java)

        val winesObserver = Observer<ArrayList<Wine>>{
            Log.d("wines:", it.toString() )

            adaptador = AdaptadorVinos(this, it )
            recyclerView.adapter = adaptador
        }
        bodegaViewModel.getWineList()
        bodegaViewModel.getWineListLiveData().observe(this,winesObserver)


        recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        layoutManager = GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL,false)
        recyclerView.layoutManager = layoutManager
}
}