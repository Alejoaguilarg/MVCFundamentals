package com.fundamentals.mvcfundamentals.Service;

import com.fundamentals.mvcfundamentals.Models.Vacante;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class VacantesServiceImp implements IVacantesService {

    List<Vacante> listado = null;

    public VacantesServiceImp() {
        listado = new LinkedList<>();

        Vacante vacante1 = new Vacante.Builder()
                .withId(14L)
                .withNombre("Ingeniero de sistemas")
                .withDescripcion("Se solicita ingeniero para dar soporte a intranet")
                .withFecha(new Date())
                .withSalario(46456.0)
                .withDestacado(1)
                .build();

        Vacante vacante2 = new Vacante.Builder()
                .withId(12L)
                .withNombre("Ingeniero de telecomunicaciones")
                .withDescripcion("Se solicita ingeniero para dar soporte a intranet")
                .withFecha(new Date())
                .withSalario(46456.0)
                .withDestacado(0)
                .build();

        Vacante vacante3 = new Vacante.Builder()
                .withId(1L)
                .withNombre("Ingeniero de telecomunicaciones")
                .withDescripcion("Se solicita ingeniero para dar soporte a intranet")
                .withFecha(new Date())
                .withSalario(46456.0)
                .withDestacado(1)
                .build();

        Vacante vacante4 = new Vacante.Builder()
                .withId(125L)
                .withNombre("Ingeniero de telecomunicaciones")
                .withDescripcion("Se solicita ingeniero para dar soporte a intranet")
                .withFecha(new Date())
                .withSalario(46456.0)
                .withDestacado(0)
                .build();

        Vacante vacante5 = new Vacante.Builder()
                .withId(125L)
                .withNombre("Desarrollador de software")
                .withDescripcion("Se solicita Desarrollador backend")
                .withFecha(new Date())
                .withSalario(46456.0)
                .withDestacado(1)
                .build();

        listado.add(vacante1);
        listado.add(vacante2);
        listado.add(vacante3);
        listado.add(vacante4);
        listado.add(vacante5);

    }

    @Override
    public List<Vacante> buscarTodas() {
        return listado;
    }

    @Override
    public Vacante buscarId(Long idVacante) {
        Predicate<Vacante> idPredicate = v -> v.getId() == idVacante;

        //filtra y retorna la vacante por id
        Vacante vacante = listado.stream()
                .filter(idPredicate)
                .findFirst() //encuentra la primera coindicencia del id
                .get();
        return vacante;
    }

    @Override
    public void guardar(Vacante vacante) {
        listado.add(vacante);
    }


}
