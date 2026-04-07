package com.weg.reenginered.infrastructure.persistence.local;

import com.weg.reenginered.infrastructure.persistence.stock.StockJpa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "local")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LocalJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer floor;

    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockJpa> stocks;
}
