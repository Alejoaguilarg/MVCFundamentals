package com.fundamentals.mvcfundamentals.Controllers;

import com.fundamentals.mvcfundamentals.Models.Categoria;
import com.fundamentals.mvcfundamentals.Service.ICategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriasController {

    @Autowired
    private ICategoriasService serviceCategorias;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String mostrarIndex(Model model) {
        List<Categoria> lista = serviceCategorias.buscarTodas();
        model.addAttribute("categorias", lista);
        return "categorias/listCategorias";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String crear(Categoria categoria) {
        return "categorias/formCategoria";
    }

    @PostMapping("/save")
    public String guardar(Categoria categoria, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                System.out.println("error: " + error.getDefaultMessage());
            }
            return "categorias/formCategoria";
        }

        // Guadamos el objeto categoria en la bd
        serviceCategorias.guardar(categoria);
        attributes.addFlashAttribute("msg", "Los datos de la categoría fueron guardados!");
        return "redirect:/categorias/index";
    }
}
