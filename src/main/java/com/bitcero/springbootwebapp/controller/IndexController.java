package com.bitcero.springbootwebapp.controller;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.bitcero.springbootwebapp.models.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class IndexController {
    @RequestMapping(value={"/index", "/", "/home"}, method = RequestMethod.GET )
    public String index(Model model) {
        model.addAttribute("titulo", "Hola Spring Framework");
        return "index";
    }

    @GetMapping(value = "/indexModelMap")
    public String index(ModelMap model) {
        model.addAttribute("titulo", "Hola Spring Framework with ModelMap");
        return "index";
    }

    @GetMapping(value = "/indexMap")
    public String index(Map<String, Object> map) {
        map.put("titulo", "Hola Spring Framework with Map");
        return "index";
    }

    @GetMapping(value = "/indexModelAndView")
    public ModelAndView index(ModelAndView mv) {
        mv.addObject("titulo", "Hola Spring Framework with Model And View");
        // Se le pasa el nombre de la vista.
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellidos("Pavón");

        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Perfil de usuario ".concat(usuario.getNombre()));


        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model) {
        // List<Usuario> usuarios = new ArrayList<>();
        // usuarios.add(new Usuario("Andres", "Guzman", "andres@email.com"));
        // usuarios.add(new Usuario("Pepe", "Gonzalez", "pepe@email.com"));
        // usuarios.add(new Usuario("Maria", "Perez", "Maria@email.com"));

        List<Usuario> usuarios = Arrays.asList(
            new Usuario("Andres", "Guzman", "andres@email.com"),
            new Usuario("Pepe", "Gonzalez", "pepe@email.com"),
            new Usuario("Maria", "Perez", "Maria@email.com"),
            new Usuario("Juan", "Pavón", "juan@email.com")
        );

        model.addAttribute("titulo", "Listado de usuarios");
        model.addAttribute("usuarios", usuarios);
        return "listar";
    }
}
