package com.example.licenta.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProdusDto {
    private Long id;

    private String categorie;

    private Double cantitate;

    private String descriere;

    private Double pret;

    private Long stoc;


}
