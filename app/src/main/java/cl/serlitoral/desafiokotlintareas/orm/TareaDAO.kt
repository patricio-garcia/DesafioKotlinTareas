package cl.serlitoral.desafiokotlintareas.orm

import androidx.room.*
import cl.serlitoral.desafiokotlintareas.task.Tarea

@Dao //Se define como DAO
interface TareaDAO {
    //Se definine las Querys

    //En caso de tarea repetida, se reemplaza
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertarTarea(tarea: Tarea)

    @Update
    fun actualizarTarea(tarea: Tarea)

    @Delete
    fun eliminarTarea(tarea: Tarea)

    @Query("SELECT * FROM Tarea")
    fun getTareas(): List<Tarea>
}