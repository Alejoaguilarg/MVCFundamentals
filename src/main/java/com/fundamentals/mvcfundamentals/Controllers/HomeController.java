package com.fundamentals.mvcfundamentals.Controllers;

import com.fundamentals.mvcfundamentals.Models.Vacante;
import com.fundamentals.mvcfundamentals.Service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private IVacantesService serviceVacantes;

    @GetMapping("/tabla")
    public String mostrarTabla(Model model) {
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "tabla";
    }
    
    @GetMapping("/detalle")
    public String mostrarDetalle(Model model){
        Vacante vacante = new Vacante.Builder()
                .withId(12L)
                .withNombre("Ingeniero de telecomunicaciones")
                .withDescripcion("Se solicita ingeniero para dar soporte a intranet")
                .withFecha(new Date())
                .withSalario(46456.0)
                .withDestacado(1)
                .withImagen("logo1.png")
                .build();
        model.addAttribute("vacante", vacante);
        return "detalle";
    }

    @GetMapping(value = "/")
    public String ShowHome(Model model){
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "home";

    }

    @GetMapping("/listado")
    public String ShowList(Model model){
        List<String> lista = new LinkedList<>();
        lista.add("Ingeniero de sistemas");
        lista.add("auxiliar de contrabilidad");
        lista.add("Arquitecto");

        model.addAttribute("empleos", lista);
        return "listado";
    }




}
