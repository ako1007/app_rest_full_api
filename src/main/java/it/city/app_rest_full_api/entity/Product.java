package it.city.app_rest_full_api.entity;

import it.city.app_rest_full_api.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsNameEntity {

    @ManyToOne
    private Category category;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double shippingPrice;

    @Column(nullable = false)
    private String description;

}
