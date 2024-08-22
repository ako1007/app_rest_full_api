package it.city.app_rest_full_api.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResProduct {

  private Integer id;

  private Integer categoryId;

  private String categoryName;

  private String name;

  private double price;

  private double shippingPrice;

  private String description;
}
