package com.example.licenta.controller;

import com.example.licenta.model.Comanda;
import com.example.licenta.model.Status;
import com.example.licenta.service.StatusRequest;
import com.example.licenta.service.StatusService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class StatusController {

    private final StatusService statusService;

    @GetMapping("/statusuri/get-statusuri")
    ResponseEntity<String> getStatusuri() throws JsonProcessingException {
        System.out.println(statusService.findAll());
        return ResponseEntity.ok(statusService.findAll());
    }

    @PostMapping("/statusuri/adauga-status")
    ResponseEntity<String> adaugaStatus(@RequestParam Long id, @RequestParam String nume,
            @RequestParam StatusRequest comanda) {
        statusService.adaugaStatus(id, nume, comanda);
        return ResponseEntity.ok("Statusul a fost adaugat cu succes!");
    }

    @PutMapping("/statusuri/modifica-status")
    ResponseEntity<String> modificaStatus(@RequestParam Long id, @RequestParam String nume,
            @RequestParam Comanda comanda) {
        statusService.modificaStatus(new Status(id, nume, comanda));
        return ResponseEntity.ok("Statusul a fost modificat cu succes!");
    }

    @DeleteMapping("/statusuri/sterge-status")
    ResponseEntity<String> stergeStatus(@RequestParam Long id) {
        statusService.stergeStatus(id);
        return ResponseEntity.ok("Statusul a fost sters cu succes!");
    }
}
