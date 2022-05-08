package com.jpbelajar.web2.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="PRODUCT")
@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    @NotEmpty(message = "Product name should not be empty")
    private String name;

    @NotEmpty(message = "Product description should not be empty")
    private String description;
    private double price;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(name="PRODUCT_SUPPLIER",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name="supplier_id"))
    @JsonManagedReference
    private Set<Supplier> suppliers;
}
