package pe.edu.upeu.asistencia.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upeu.asistencia.exceptions.AppException;

import pe.edu.upeu.asistencia.exceptions.ResourceNotFoundException;

import pe.edu.upeu.asistencia.models.Materialesx;
import pe.edu.upeu.asistencia.repositories.MaterialesxRepository;

/**
 *
 * @author DELL
 */
@RequiredArgsConstructor
@Service
@Transactional
public class MaterialesxServiceImp implements MaterialesxService {

    @Autowired
    private MaterialesxRepository materialesxRepo;

    @Override
    public Materialesx save(Materialesx materialesx) {

        try {
            return materialesxRepo.save(materialesx);
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public List<Materialesx> findAll() {
        try {
            return materialesxRepo.findAll();
        } catch (Exception e) {
            throw new AppException("Error-" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public Map<String, Boolean> delete(Long id) {
        Materialesx materialesxx = materialesxRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materialesx not exist with id :" + id));

        materialesxRepo.delete(materialesxx);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);

        return response;
    }

    @Override
    public Materialesx getMaterialesxById(Long id) {
        Materialesx findMaterialesx = materialesxRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Materialesx not exist with id :" + id));
        return findMaterialesx;
    }

    @Override
    public Materialesx update(Materialesx materialesx, Long id) {
        Materialesx materialesxx = materialesxRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Periodo not exist with id :" + id));
        materialesxx.setModFh(materialesx.getModFh());
        materialesxx.setHoraReg(materialesx.getHoraReg());
        materialesxx.setOfflinex(materialesx.getOfflinex());
        return materialesxRepo.save(materialesxx);
    }

}
