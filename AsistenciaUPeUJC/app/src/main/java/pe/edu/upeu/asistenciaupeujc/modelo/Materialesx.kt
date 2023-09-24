package pe.edu.upeu.asistenciaupeujc.modelo

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "materialesx",
    foreignKeys = [
        ForeignKey(
            entity = Actividad::class,
            parentColumns = ["id"],
            childColumns = ["actividadId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Materialesx(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var cui: String,
    var tipoCui: String,
    var materEntre: String,
    var fecha: String,
    var horaReg: String,
    var latituda: String,
    var longituda: String,
    var modFh: String,
    var offlinex: String,
    var actividadId: Long

)


data class MaterialesxReport(
    var id: Long,
    var cui: String,
    var tipoCui: String,
    var materEntre: String,
    var fecha: String,
    var horaReg: String,
    var latituda: String,
    var longituda: String,
    var modFh: String,
    var offlinex: String,
   /*var actividadId: String,*/
    var actividadId: List<Long>
)
