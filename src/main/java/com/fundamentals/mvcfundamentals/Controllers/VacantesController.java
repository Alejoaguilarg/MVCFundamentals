package com.fundamentals.mvcfundamentals.Controllers;

import Util.Utileria;
import com.fundamentals.mvcfundamentals.Models.Vacante;
import com.fundamentals.mvcfundamentals.Service.ICategoriasService;
import com.fundamentals.mvcfundamentals.Service.IVacantesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/vacantes")
public class VacantesController {

    @Value("${MVCFundamentals.ruta.imagenes}")
    private String ruta;

    @Autowired
    private IVacantesService serviceVacantes;

    @Autowired
    private ICategoriasService serviceCategorias;

    @GetMapping("/create")
    public String crear(Vacante vacante, Model model) {
        model.addAttribute("categorias", serviceCategorias.buscarTodas());
        return "vacantes/formVacante";
    }

    @PostMapping("/save")
    public String guardar(Vacante vacante, BindingResult result, RedirectAttributes attributes,
                          @RequestParam("archivoImagen") MultipartFile multiPart) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("error: " + error.getDefaultMessage());
            }
            return "vacantes/formVacante";
        }

        if (!multiPart.isEmpty()) {
            /*String ruta = "C:/empleos/img-vacantes/";*/
            String nombreImagen = Utileria.guardarArchivo(multiPart, ruta);
            if (nombreImagen != null) {
                vacante.setImagen(nombreImagen);
            }
        }
        serviceVacantes.guardar(vacante);
        System.out.println("vacante = " + vacante);
        attributes.addFlashAttribute("msg", "Registro guardado");
        return "redirect:/vacantes/index";
    }

    @GetMapping("/index")
    public String mostrarIndex(Model model) {

        List<Vacante> vacantes = serviceVacantes.buscarTodas();

        model.addAttribute("vacantes", vacantes);

        return "vacantes/listVacantes";
    }


    @GetMapping("/view/{id}")
    public String verDetalle(@PathVariable("id") Long idVacante, Model model) {

        Vacante vacante = serviceVacantes.buscarId(idVacante);

        System.out.println("vacante = " + vacante);
        model.addAttribute("vacante", vacante);

        //Buscar detalles de la vacante en la BD
        return "detalle";
    }

    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") Long idVacante, Model model) {
        System.out.println("idVacante = " + idVacante);
        model.addAttribute("idVacante", idVacante);
        return "Mensaje";
    }

    @InitBinder
    public void initDataBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

}
