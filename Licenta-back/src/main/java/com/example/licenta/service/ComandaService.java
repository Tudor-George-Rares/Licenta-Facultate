package com.example.licenta.service;

import com.example.licenta.model.Comanda;
import com.example.licenta.model.Status;
import com.example.licenta.repository.ComandaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ComandaService {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final ComandaRepository comandaRepository;

    public String findAll() throws JsonProcessingException {
        List<Comanda> comandaList = comandaRepository.findAll();
        List<String> comenziStrings = new ArrayList<>();
        for (Comanda comanda : comandaList) {
            comenziStrings.add(OBJECT_MAPPER.writeValueAsString(comanda));
        }

        return comenziStrings.toString();
    }

    public void adaugaComanda(Comanda request) {
        Comanda comanda = Comanda.builder()
                .status(request.getStatus())
                .user(request.getuser())
                .build();

        comandaRepository.save(comanda);

    }

    public void modificaComanda(Comanda request) {
        Comanda comanda = comandaRepository.findById(request.getId()).orElse(null);
        if (comanda != null) {
            comanda.setStatus(request.getStatus());
            comanda.setuser(request.getuser());
            comandaRepository.save(comanda);
        }
    }

    public void adaugaComanda() {
        Comanda comanda = Comanda.builder()
                .status(new Status(1L, null, null))
                .build();
        comandaRepository.save(comanda);
    }

    public void modificaComanda(Long id, Long status) {
        Comanda comanda = comandaRepository.findById(id).orElse(null);
        if (comanda != null) {
            comanda.setStatus(new Status(status, null, null));
            comandaRepository.save(comanda);
        }
    }

    public void stergeComanda(Long id) {
        Comanda comanda = comandaRepository.findById(id).orElse(null);
        if (comanda != null) {
            comandaRepository.delete(comanda);
        }
    }
}
