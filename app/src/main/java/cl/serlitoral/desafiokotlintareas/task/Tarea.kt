package cl.serlitoral.desafiokotlintareas.task

import androidx.room.Entity
import androidx.room.PrimaryKey


//Se inidca que esta corresponderá a una entidad (Tabla)
@Entity(tableName = "Tarea")
data class Tarea (
    //Se define el nombre de la tarea comoo Primary Key
    @PrimaryKey val nombre: String,
    var terminada: Boolean
)