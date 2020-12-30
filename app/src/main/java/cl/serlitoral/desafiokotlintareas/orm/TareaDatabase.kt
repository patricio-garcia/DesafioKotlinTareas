package cl.serlitoral.desafiokotlintareas.orm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.serlitoral.desafiokotlintareas.task.Tarea

//Se crea la Base de Datos
@Database(entities = [Tarea::class], version = 1)

//La clase debe ser abstracta y heredar de RoomDatabase
abstract class TareaDatabase: RoomDatabase() {

    //Se crea fun abstracta que sea del tipo de nuestro DAO
    abstract fun tareaDAO(): TareaDAO

    //Se debería crear un singleton para la instancia de nuestra BD
    companion object {
        private var INSTANCE: TareaDatabase? = null //podría ser nula

        //Se crea la función que obtiene la instancia, que devuelve nuestra DB
        fun getInstance(context: Context): TareaDatabase {
            //Si aún no creamos nuestra instancia se crea
            if (INSTANCE == null) {

                //Al crear la instancia, usamos .allowMainThreadQueries pues no estamos utilizando
                //funciones asíncronas y así evitamos el error de las Query
                //Encaso de hacer cambios en la BD, se debe aumentar la versión, como no tenemos el
                //exptertice para crear un script, podemos usar el .fallbackToDestructiveMigration
                //Ejemplo: .allowMainThreadQueries().fallbackToDestructiveMigration().build()
                //De esta forma se borra la BD y se crea una nueva, perdiendo los datos de la BD
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    TareaDatabase::class.java,
                    "database-tareas"
                ).allowMainThreadQueries()
                    .build()
            }

            //Se devuelve la instancia indicando que no será nulo
            return INSTANCE!!
        }
    }

}