package com.example.licenta.controller;

import com.example.licenta.dto.ProdusDto;
import com.example.licenta.service.ProdusService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProdusController {

    private final ProdusService produsService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admin/produse/add-produs")
    ResponseEntity<String> addProdus(ProdusDto request) {
        produsService.adaugaProdus(request);
        return ResponseEntity.ok("Produs adaugat cu succes");
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/admin/produse/delete-produs")
    ResponseEntity<String> deleteProdus(@RequestParam Long id) {
        produsService.stergeProdus(id);
        return ResponseEntity.ok("Produs sters cu succes");
    }

    @GetMapping("/produse/get-produse")
    ResponseEntity<String> getProduse() throws JsonProcessingException {
        System.out.println(produsService.findAll());
        return ResponseEntity.ok(produsService.findAll());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/admin/produse/update-produs")
    ResponseEntity<String> updateProdus(@RequestParam Long id, ProdusDto request) {
        produsService.modificaProdus(id, request);
        return ResponseEntity.ok("Produs updatat cu succes");
    }

}
