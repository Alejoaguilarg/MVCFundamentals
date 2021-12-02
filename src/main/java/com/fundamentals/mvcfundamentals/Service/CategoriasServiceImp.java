package com.fundamentals.mvcfundamentals.Service;

import com.fundamentals.mvcfundamentals.Models.Categoria;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class CategoriasServiceImp implements ICategoriasService {

    List<Categoria> listadoCategorias = null;

    public CategoriasServiceImp() {
        listadoCategorias = new LinkedList<Categoria>();

        // Creamos algunas Categorias para poblar la lista ...

        // Categoria 1
        Categoria cat1 = new Categoria();
        cat1.setId(1L);
        cat1.setNombre("Contabilidad");
        cat1.setDescripcion("Descripcion de la categoria Contabilidad");

        // Categoria 2
        Categoria cat2 = new Categoria();
        cat2.setId(2L);
        cat2.setNombre("Ventas");
        cat2.setDescripcion("Trabajos relacionados con Ventas");


        // Categoria 3
        Categoria cat3 = new Categoria();
        cat3.setId(3L);
        cat3.setNombre("Comunicaciones");
        cat3.setDescripcion("Trabajos relacionados con Comunicaciones");

        // Categoria 4
        Categoria cat4 = new Categoria();
        cat4.setId(4L);
        cat4.setNombre("Arquitectura");
        cat4.setDescripcion("Trabajos de Arquitectura");

        // Categoria 5
        Categoria cat5 = new Categoria();
        cat5.setId(5L);
        cat5.setNombre("Educacion");
        cat5.setDescripcion("Maestros, tutores, etc");

        // Categoria 6
        Categoria cat6 = new Categoria();
        cat5.setId(5L);
        cat5.setNombre("Desarrollo de software");
        cat5.setDescripcion("Tareas desarrolladas con backend");

        /**
         * Agregamos los 5 objetos de tipo Categoria a la lista ...
         */
        listadoCategorias.add(cat1);
        listadoCategorias.add(cat2);
        listadoCategorias.add(cat3);
        listadoCategorias.add(cat4);
        listadoCategorias.add(cat5);
        listadoCategorias.add(cat6);

    }

    @Override
    public void guardar(Categoria categoria) {
        listadoCategorias.add(categoria);
    }

    @Override
    public List<Categoria> buscarTodas() {
        return listadoCategorias;
    }

    @Override
    public Categoria buscarPorId(Long idCategoria) {

        Predicate<Categoria> isIdCategoria = c -> c.getId() == idCategoria;

        Categoria categoria = listadoCategorias.stream()
                .filter(isIdCategoria)
                .findFirst()
                .get();
        return categoria;
    }
}
