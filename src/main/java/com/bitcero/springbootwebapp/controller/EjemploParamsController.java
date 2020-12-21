package com.bitcero.springbootwebapp.controller;

import javax.servlet.http.HttpServletRequest;

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

    @GetMapping("/mix-params")
    public String mixParams(@RequestParam String saludo, @RequestParam int numero, Model model) {
        model.addAttribute("titulo", "Recibir Multiples parámetros del requesT HTTP GET");
        model.addAttribute("resultado", "El saludo enviado es: ".concat(saludo) + "Numero: " + numero);
        return "params/ver";
    }

    @GetMapping("/mix-params-request")
    public String mixParams(HttpServletRequest request, Model model) {
        int numero;
        String saludo = request.getParameter("saludo");
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            numero = 0;
        }
        model.addAttribute("titulo", "Recibir Multiples parámetros del requesT HTTP GET");
        model.addAttribute("resultado", "El saludo enviado es: ".concat(saludo) + "Numero: " + numero);
        return "params/ver";
    }
}
