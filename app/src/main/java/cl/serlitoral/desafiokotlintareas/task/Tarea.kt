package cl.serlitoral.desafiokotlintareas.task

import androidx.room.Entity
import androidx.room.PrimaryKey


//Se inidca que ésta corresponderá a una entidad (Tabla)
//Si queremos podemos defnir el nombre de la tabla, o dejarla con el nombre que asume de la clase
@Entity(tableName = "Tarea")
data class Tarea (
    //Se define el nombre de la tarea comoo Primary Key
    @PrimaryKey val nombre: String,
    var terminada: Boolean
)