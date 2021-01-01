package cl.serlitoral.desafiokotlintareas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import cl.serlitoral.desafiokotlintareas.databinding.ActivityAgregarTareaBinding
import kotlinx.android.synthetic.main.activity_agregar_tarea.*

class AgregarTareaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAgregarTareaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAgregarTareaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        crear_tarea.setOnClickListener {
            val tareaDescripcion = binding.tarea.text.toString()
            if(tareaDescripcion.isEmpty())
                Toast.makeText(this, "Debes ingresar una tarea", Toast.LENGTH_LONG).show()
            else {
                val intent = Intent()
                intent.putExtra("tarea", tareaDescripcion)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}