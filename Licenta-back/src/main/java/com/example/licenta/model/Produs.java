package com.example.licenta.model;

import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String categorie;

    private Long stoc;

    private Double cantitate;

    private String descriere;

    private Double pret;

    @OneToMany(mappedBy = "produs", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Poza> poze;

    @ManyToMany(mappedBy = "produs")
    private List<Comanda> comenzi;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Long getStoc() {
        return stoc;
    }

    public void setStoc(Long stoc) {
        this.stoc = stoc;
    }

    public Double getCantitate() {
        return cantitate;
    }

    public void setCantitate(Double cantitate) {
        this.cantitate = cantitate;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public List<Poza> getPoze() {
        return poze;
    }

    public void setPoze(List<Poza> poze) {
        this.poze = poze;
    }

    public List<Comanda> getComenzi() {
        return comenzi;
    }

    public void setComenzi(List<Comanda> comenzi) {
        this.comenzi = comenzi;
    }
}
