package com.jpbelajar.web2.models.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="SUPPLIER")
@Getter
@Setter
public class Supplier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, unique = true)
    private String name;

    private String address;

    @Column(length=150, unique = true, nullable= false  )
    private String email;

    @ManyToMany(mappedBy = "suppliers")
    @JsonBackReference
    private Set<Product> products;
}
