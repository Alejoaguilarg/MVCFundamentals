package com.fundamentals.mvcfundamentals.Service;

import com.fundamentals.mvcfundamentals.Models.Categoria;

import java.util.List;


public interface ICategoriasService {

    void guardar(Categoria categoria);
    List<Categoria> buscarTodas();
    Categoria buscarPorId(Long idCategoria);
}
