package com.example.licenta.service;

import com.example.licenta.dto.ProdusDto;
import com.example.licenta.model.Produs;
import com.example.licenta.repository.ProdusRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdusService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final ProdusRepository produsRepository;

    public void adaugaProdus(ProdusDto request) {
        Produs produs = Produs.builder()
                .categorie(request.getCategorie())
                .cantitate(request.getCantitate())
                .descriere(request.getDescriere())
                .stoc(request.getStoc())
                .pret(request.getPret())
                .build();

        produsRepository.save(produs);

    }

    public void stergeProdus(Long id) {
        produsRepository.deleteById(id);
    }

    public String findAll() throws JsonProcessingException {
        List<Produs> produsList = produsRepository.findAll();
        List<String> produsStrings = new ArrayList<>();
        for(Produs produs : produsList) {
            produsStrings.add(OBJECT_MAPPER.writeValueAsString(produs));
        }

        return produsStrings.toString();
    }

    public void modificaProdus(Long id, ProdusDto request) {
        Produs produs = produsRepository.findById(id).get();
        produs.setCategorie(request.getCategorie());
        produs.setCantitate(request.getCantitate());
        produs.setDescriere(request.getDescriere());
        produs.setStoc(request.getStoc());
        produs.setPret(request.getPret());
        produsRepository.save(produs);
    }
}
