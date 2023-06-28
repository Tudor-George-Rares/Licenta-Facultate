package com.example.licenta.service;

import com.example.licenta.model.Status;
import com.example.licenta.repository.StatusRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatusService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final StatusRepository statusRepository;

    public String findAll() throws JsonProcessingException {
        List<Status> statusList = statusRepository.findAll();
        List<String> statusStrings = new ArrayList<>();
        for (Status status : statusList) {
            statusStrings.add(OBJECT_MAPPER.writeValueAsString(status));
        }
        return statusStrings.toString();
    }
    public void adaugaStatus(Long id, String nume, StatusRequest request) {
        Status status = Status.builder()
                .numeStatus(request.getNumeStatus())
                .build();

        statusRepository.save(status);
    }
    public void modificaStatus(Status request) {
        Status status = statusRepository.findById(request.getId()).orElse(null);
        if (status != null) {
            status.setNumeStatus(request.getNumeStatus());
            statusRepository.save(status);
        }
    }
    public void stergeStatus(Long request) {
        Status status = statusRepository.findById(request).orElse(null);
        if (status != null) {
            statusRepository.delete(status);
        }
    }

}
