package com.example.licenta.controller;

import com.example.licenta.service.ComandaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ComandaController {

    private final ComandaService comandaService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/comenzi/get-comenzi")
    ResponseEntity<String> getComenzi() throws JsonProcessingException {
        System.out.println(comandaService.findAll());
        return ResponseEntity.ok(comandaService.findAll());
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/comenzi/get-comenzile-mele")
    ResponseEntity<String> getComenzileMele() throws JsonProcessingException {
        System.out.println(comandaService.findAll());
        return ResponseEntity.ok(comandaService.findAll());
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/comenzi/adauga-comanda")
    ResponseEntity<String> adaugaComanda() {
        comandaService.adaugaComanda();
        return ResponseEntity.ok("Comanda a fost adaugata cu succes!");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/comenzi/modifica-comanda")
    ResponseEntity<String> modificaComanda(@RequestParam Long id, @RequestParam Long status) {
        comandaService.modificaComanda(id, status);
        return ResponseEntity.ok("Comanda a fost modificata cu succes!");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/comenzi/sterge-comanda")
    ResponseEntity<String> stergeComanda(@RequestParam Long id) {
        comandaService.stergeComanda(id);
        return ResponseEntity.ok("Comanda a fost stearsa cu succes!");
    }

}
