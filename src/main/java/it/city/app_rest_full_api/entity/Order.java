package it.city.app_rest_full_api.entity;

import it.city.app_rest_full_api.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order extends AbsEntity {

    @ManyToOne
    private Product product;

    private double total;

    private Integer quantity;

    private String shippingAddress;

    @ManyToOne
    private User user;


}




