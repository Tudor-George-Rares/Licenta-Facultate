package com.example.licenta.controller;

import com.example.licenta.service.PozaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PozaController {
    private final PozaService pozaService;

    @GetMapping("/poze/get-poze")
    ResponseEntity<String> getPoze() throws JsonProcessingException {
        return ResponseEntity.ok(pozaService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/poze/adauga-poza")
    ResponseEntity<String> adaugaPoza() {
        pozaService.adaugaPoza();
        return ResponseEntity.ok("Poza a fost adaugata cu succes!");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/poze/modifica-poza")
    ResponseEntity<String> modificaPoza(@RequestParam Long id, @RequestParam String nume) {
        pozaService.modificaPoza(id, nume);
        return ResponseEntity.ok("Poza a fost modificata cu succes!");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/poze/sterge-poza")
    ResponseEntity<String> stergePoza(@RequestParam Long id) {
//        pozaService.stergePoza(id);
        return ResponseEntity.ok("Poza a fost stearsa cu succes!");
    }
}
