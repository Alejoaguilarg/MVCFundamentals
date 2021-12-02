package com.fundamentals.mvcfundamentals.Service;

import com.fundamentals.mvcfundamentals.Models.Vacante;

import java.util.List;

public interface IVacantesService {
    List<Vacante> buscarTodas();

    Vacante buscarId(Long idVacante);
    void guardar(Vacante vacante);
}
