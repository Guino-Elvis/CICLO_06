package pe.edu.upeu.asistenciaupeujc.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad
import pe.edu.upeu.asistenciaupeujc.modelo.Materialesx

@Dao
interface MaterialesxDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarMaterialesx(materialesx: Materialesx)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarMaterialesxes(materialesx: List<Materialesx>)

    @Update
    suspend fun modificarMaterialesx(materialesx: Materialesx)

    @Delete
    suspend fun eliminarMaterialesx(materialesx: Materialesx)

    @Query("select * from materialesx")
    fun reportatMaterialesx():LiveData<List<Materialesx>>

    @Query("select * from materialesx where id=:idx")
    fun buscarMaterialesx(idx: Long): LiveData<Materialesx>
}