package com.example.licenta.model;

import lombok.*;
import lombok.Builder.Default;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.example.licenta.models.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comanda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "comanda_produs", joinColumns = { @JoinColumn(name = "id_comanda") }, inverseJoinColumns = {
            @JoinColumn(name = "id_produs") })
    @Default
    private List<Produs> produs = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getuser() {
        return user;
    }

    public void setuser(User user) {
        this.user = user;
    }

    public List<Produs> getProdus() {
        return produs;
    }

    public void setProdus(List<Produs> produs) {
        this.produs = produs;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
