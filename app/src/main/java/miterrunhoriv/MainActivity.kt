package miterrunhoriv

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.os.Bundle
import android.telecom.Call
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import miterrunhoriv.R
import miterrunhoriv.model.Wine
import miterrunhoriv.services.db.MyApiAdapter
import miterrunhoriv.services.db.MyApiService
import miterrunhoriv.services.db.WinesResponse
import miterrunhoriv.view.AdaptadorVinos
import miterrunhoriv.view.Vinos
import miterrunhoriv.view.VinosVector
import retrofit2.Response
import javax.security.auth.callback.Callback
import kotlin.coroutines.coroutineContext

class MainActivity : AppCompatActivity() {

lateinit var bMiTerrunho:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bMiTerrunho= miTerrrunho
        bMiTerrunho.setOnClickListener{
            val intent = Intent(this, BodegaActivity::class.java)
            intent.putExtra("Bodega","MiTerrunho" )
            startActivity(intent)
            }

        obtenerdatos()

    }

    //asignar el valor obtenido al boton
    fun asignaTexto(nombre: String){
        bMiTerrunho.text= nombre
    }

    //obtiene datos de la api
    fun obtenerdatos(){
        val call: retrofit2.Call<WinesResponse> = MyApiAdapter.apiService!!.getWines()
        call.enqueue(WinesCallBack())

    }



    inner class WinesCallBack(): retrofit2.Callback <WinesResponse> {

        override fun onFailure(call: retrofit2.Call<WinesResponse>, t: Throwable) {
           // Toast.makeText(context, t.localizedMessage, Toast.LENGTH_SHORT).show()
            Log.d("TAG", "aca fallo")
        }

        override fun onResponse(
            call: retrofit2.Call<WinesResponse>,
            response: Response<WinesResponse>
        ) {
            if (response.isSuccessful){
                var wineResponse :WinesResponse? = response.body()
                if (wineResponse != null) {
                    var vino: ArrayList<Wine> = wineResponse.data
                    var nombre: String = vino[0].name
                    Log.d("VINO", nombre)
                    bMiTerrunho.text = nombre


                    //Toast.makeText(context, nombre, Toast.LENGTH_SHORT).show()
                }
            }else{
               // Toast.makeText(context,"error en el formato",Toast.LENGTH_SHORT).show()
            }
        }

    }

}
