package pe.edu.upeu.asistencia.services;

import java.util.List;
import java.util.Map;

import pe.edu.upeu.asistencia.models.Materialesx;

/**
 *
 * @author DELL
 */
public interface MaterialesxService {
    Materialesx save(Materialesx materialesx);

    List<Materialesx> findAll();

    Map<String, Boolean> delete(Long id);

    Materialesx getMaterialesxById(Long id);

    Materialesx update(Materialesx materialesx, Long id);
}
