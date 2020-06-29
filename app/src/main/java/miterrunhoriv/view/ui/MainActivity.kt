package miterrunhoriv.view.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import miterrunhoriv.R

class MainActivity : AppCompatActivity() {

    lateinit var bMiTerrunho:Button
    lateinit var bVistaflores:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bMiTerrunho= miTerrrunho
        bMiTerrunho.setOnClickListener{
            val intent = Intent(this, BodegaActivity::class.java)
            intent.putExtra("Bodega","MiTerrunho" )
            startActivity(intent)
        }
        bVistaflores= vistaFlores
        bVistaflores.setOnClickListener{
            val intent = Intent(this, BodegaActivity::class.java)
            intent.putExtra("Bodega","VistaFlores" )
            startActivity(intent)
        }


    }



}
