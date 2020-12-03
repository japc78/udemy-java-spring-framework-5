package com.bitcero.springbootwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Enviar parametros del requesT HTTP GET");

        return "params/index";

    }

    @GetMapping("/string")
    public String param(@RequestParam(name="texto", required = false, defaultValue = "Valor por defecto") String texto, Model model) {
        // http://localhost:8080/params/string?texto=hola%20spring
        model.addAttribute("titulo", "Recibir parametros del requesT HTTP GET");
        model.addAttribute("resultado", "El texto enviado es: ".concat(texto));
        return "params/ver";
    }
}
