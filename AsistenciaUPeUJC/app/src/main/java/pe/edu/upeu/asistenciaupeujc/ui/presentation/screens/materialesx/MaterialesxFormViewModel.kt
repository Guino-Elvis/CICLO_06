package pe.edu.upeu.asistenciaupeujc.ui.presentation.screens.materialesx

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pe.edu.upeu.asistenciaupeujc.modelo.Actividad
import pe.edu.upeu.asistenciaupeujc.modelo.Materialesx
import pe.edu.upeu.asistenciaupeujc.repository.ActividadRepository
import pe.edu.upeu.asistenciaupeujc.repository.MaterialesxRepository
import javax.inject.Inject

@HiltViewModel
class MaterialesxFormViewModel @Inject constructor(
    private val activRepo: MaterialesxRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    private val _isLoading: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>(false)
    }

    fun getMaterialesx(idX: Long): LiveData<Materialesx> {
        return activRepo.buscarMaterialesxId(idX)
    }

    val isLoading: LiveData<Boolean> get() = _isLoading


    fun addMaterialesx(materialesx: Materialesx){
        viewModelScope.launch (Dispatchers.IO){
            Log.i("REAL", materialesx.toString())
            activRepo.insertarMaterialesx(materialesx)
        }
    }
    fun editMaterialesx(materialesx: Materialesx){
        viewModelScope.launch(Dispatchers.IO){
            activRepo.modificarRemoteMaterialesx(materialesx)
        }
    }
}