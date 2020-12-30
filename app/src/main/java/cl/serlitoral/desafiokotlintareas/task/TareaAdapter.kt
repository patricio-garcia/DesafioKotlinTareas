package cl.serlitoral.desafiokotlintareas.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import cl.serlitoral.desafiokotlintareas.R
import kotlinx.android.synthetic.main.tarea_item.view.*

class TareaAdapter(private var tareas: ArrayList<Tarea> = ArrayList(), private val listener: TareaAdapterListener) : RecyclerView.Adapter<TareaAdapter.TareaViewHolder>() {

    class TareaViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tarea_item, parent, false)
        return TareaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tareas.size
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        holder.itemView.nombre.text = tareas[position].nombre
        holder.itemView.tarea_terminada.isChecked = tareas[position].terminada
        if(holder.itemView.tarea_terminada.isChecked)
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.tarea_terminada))
        else
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.tarea_no_terminada))
        holder.itemView.tarea_terminada.setOnCheckedChangeListener { buttonView, isChecked ->
            listener.onTareaChecked(tareas[position], isChecked)
            if(isChecked)
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.tarea_terminada))
            else
                holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.tarea_no_terminada))
        }
    }

    //Funciones personalizadas

    fun agregarTarea(tarea: Tarea) {
        tareas.add(tarea)
        notifyItemInserted(itemCount)
    }

    //Ya no la utilizo, se cambia por la interface
    fun setTareas(tareas : ArrayList<Tarea>) {
        this.tareas = tareas
        notifyDataSetChanged()
    }

    fun getTarea(posicion: Int) : Tarea {
        return tareas[posicion]
    }

    fun eliminarTarea(posicion: Int) {
        tareas.removeAt(posicion)
        notifyItemRemoved(posicion)
    }

    fun restaurarTarea(posicion: Int, tarea: Tarea) {
        tareas.add(posicion, tarea)
        notifyItemInserted(posicion)
    }

    fun cambiarPosicionItem(posicionInicial: Int, posicionFinal: Int) {
        val tarea = tareas[posicionInicial]
        tareas.removeAt(posicionInicial)
        tareas.add(posicionFinal, tarea)
        notifyItemMoved(posicionInicial, posicionFinal)
    }
}

//Se crea una interfaz para poder actualizar las tareas
interface TareaAdapterListener {
    fun onTareaChecked(tarea: Tarea, terminada: Boolean)
}