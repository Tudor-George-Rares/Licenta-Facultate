package com.example.licenta.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Poza {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String linkPoza;

    @ManyToOne
    private Produs produs;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkPoza() {
        return linkPoza;
    }

    public void setLinkPoza(String linkPoza) {
        this.linkPoza = linkPoza;
    }

    public Produs getProdus() {
        return produs;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }
}
