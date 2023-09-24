package pe.edu.upeu.asistenciaupeujc.repository

import android.util.Log
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pe.edu.upeu.asistenciaupeujc.data.local.dao.ActividadDao
import pe.edu.upeu.asistenciaupeujc.data.local.dao.MaterialesxDao
import pe.edu.upeu.asistenciaupeujc.data.remote.RestActividad
import pe.edu.upeu.asistenciaupeujc.data.remote.RestMaterialesx
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad
import pe.edu.upeu.asistenciaupeujc.modelo.Materialesx
import pe.edu.upeu.asistenciaupeujc.utils.TokenUtils
import javax.inject.Inject

interface MaterialesxRepository {

    suspend fun deleteMaterialesx(materialesx: Materialesx)
    fun reportarMaterialesxes(): LiveData<List<Materialesx>>

    fun buscarMaterialesxId(id:Long): LiveData<Materialesx>

    suspend fun insertarMaterialesx(materialesx: Materialesx):Boolean

    suspend fun modificarRemoteMaterialesx(materialesx: Materialesx):Boolean
}

class MaterialesxRepositoryImp @Inject constructor(
    private val restMaterialesx: RestMaterialesx,
    private val materialesxDao: MaterialesxDao
): MaterialesxRepository{
    override suspend fun deleteMaterialesx(materialesx: Materialesx){
        CoroutineScope(Dispatchers.IO).launch {
            restMaterialesx.deleteMaterialesx(TokenUtils.TOKEN_CONTENT,materialesx.id)
        }
        materialesxDao.eliminarMaterialesx(materialesx)
    }


    override fun reportarMaterialesxes(): LiveData<List<Materialesx>> {
        try {
            CoroutineScope(Dispatchers.IO).launch{
                delay(3000)
                val data=restMaterialesx.reportarMaterialesx(TokenUtils.TOKEN_CONTENT).body()!!
                materialesxDao.insertarMaterialesxes(data)
            }
        }catch (e:Exception){
            Log.i("ERROR", "Error: ${e.message}")
        }
        return materialesxDao.reportatMaterialesx()
    }

    override fun buscarMaterialesxId(id:Long): LiveData<Materialesx> {
        return  materialesxDao.buscarMaterialesx(id)
    }


    override suspend fun insertarMaterialesx(materialesx: Materialesx):Boolean{
        return restMaterialesx.insertarMaterialesx(TokenUtils.TOKEN_CONTENT, materialesx).body()!=null
    }

    override suspend fun modificarRemoteMaterialesx(materialesx: Materialesx):Boolean{
        var dd:Boolean=false
        CoroutineScope(Dispatchers.IO).launch {
            Log.i("VER", TokenUtils.TOKEN_CONTENT)
        }
        return restMaterialesx.actualizarMaterialesx(TokenUtils.TOKEN_CONTENT, materialesx.id, materialesx).body()!=null
    }
}