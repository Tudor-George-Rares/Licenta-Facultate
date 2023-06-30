package com.example.licenta.service;

import com.example.licenta.model.Poza;
import com.example.licenta.repository.PozaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PozaService {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final PozaRepository pozaRepository;

    public String findAll() throws JsonProcessingException {
        List<Poza> pozaList = pozaRepository.findAll();
        List<String> pozeStrings = new ArrayList<>();
        for (Poza poza : pozaList) {
            pozeStrings.add(OBJECT_MAPPER.writeValueAsString(poza));
        }
        return pozeStrings.toString();
    }
    public void adaugaPoza(Poza request) {
        Poza poza = Poza.builder()
                .linkPoza(request.getLinkPoza())
                .produs(request.getProdus())
                .build();

        pozaRepository.save(poza);
    }
    public void modificaPoza(Poza request) {
        Poza poza = pozaRepository.findById(request.getId()).orElse(null);
        if (poza != null) {
            poza.setLinkPoza(request.getLinkPoza());
            poza.setProdus(request.getProdus());
            pozaRepository.save(poza);
        }
    }
    public void stergePoza(Long request) {
        Poza poza = (Poza) pozaRepository.findById(request.getClass()).orElse(null);
        if (poza != null) {
            pozaRepository.delete(poza);
        }
    }

    public void adaugaPoza() {
    }

    public void modificaPoza(Long id, String nume) {
    }
}
