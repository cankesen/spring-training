package com.prodyna.training.examples.mapstruct.handson;

import java.io.Serializable;
import java.util.List;
import lombok.Data;

public class BrandDto implements Serializable {

  private String brandId;

  private String brandName;

  private List<ProductDto> offersProducts;

}
