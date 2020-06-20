package miterrunhoriv.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import miterrunhoriv.R
import miterrunhoriv.model.Wine


class AdaptadorVinos  (context: Context, vinos: Vinos) : RecyclerView.Adapter<AdaptadorVinos.ViewHolder>() {

    var vinos: Vinos= vinos
    var context: Context = context
   var inflador:LayoutInflater = (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
    lateinit var onClickListener: View.OnClickListener

    //Creamos nuestro ViewHolder, con los tipos de elementos a modificar
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nombre: TextView
        var origen: TextView
        var foto: ImageView
        var cardVino: LinearLayout

        init {
            nombre = itemView.findViewById<View>(R.id.nombre2) as TextView
            origen = itemView.findViewById<View>(R.id.origen2) as TextView
            foto = itemView.findViewById<View>(R.id.foto2) as ImageView
            cardVino = itemView.findViewById<View>(R.id.cardVino) as LinearLayout

        }
    }
    // Creamos el ViewHolder con las vista de un elemento sin personalizar
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder  {
        // Inflamos la vista desde el xml
        val v: View = inflador.inflate(R.layout.card_vino, null)
        //v.setOnClickListener(onClickListener)
        return miterrunhoriv.view.AdaptadorVinos.ViewHolder(v)
    }


    // Usando como base el ViewHolder y lo personalizamos
    override fun onBindViewHolder( holder: miterrunhoriv.view.AdaptadorVinos.ViewHolder, posicion: Int) {
        val vino: Wine = vinos.elemento(posicion)
        personalizaVista(holder, vino)

        var margin:Int= dptopx(5)

        var layoutParams :FrameLayout.LayoutParams = holder.cardVino.layoutParams as FrameLayout.LayoutParams
        layoutParams.setMargins(margin,margin,margin,margin)
        holder.cardVino.layoutParams = layoutParams;
    }

    // Personalizamos un ViewHolder a partir de un lugar
    fun personalizaVista(holder: miterrunhoriv.view.AdaptadorVinos.ViewHolder, vino: Wine) {
        holder.nombre.setText(vino.name)
        holder.origen.setText(vino.origin)
        var dFoto= R.drawable.mtecs
        when (vino.image) {
            "mtecs" -> dFoto= R.drawable.mtecs
            "mtesb"-> dFoto= R.drawable.mtesb
            "mtur"-> dFoto= R.drawable.mtur
            }
        holder.foto.setImageResource(dFoto)
        holder.foto.scaleType = ImageView.ScaleType.FIT_END
            }

    // Indicamos el número de elementos de la lista
    override fun getItemCount(): Int {
        return vinos.tamanyo()
    }

    fun setOnItemClickListener(onClickListener: View.OnClickListener?) {
        this.onClickListener = onClickListener!!
    }

    private fun dptopx(dp: Int): Int{
        var px: Float = dp* context.resources.displayMetrics.density
        return px.toInt()
    }

}