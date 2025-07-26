package br.ufba.tomorrow.tomogram.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AloController {
    @PostMapping("/alo")
    public String alo() {
        return "Alô, mundo!";
    }

    @GetMapping("/alo/{nome}")
    public String alo2(@PathVariable String nome) {
        return "Alô, " + nome + "!";
    }
}
