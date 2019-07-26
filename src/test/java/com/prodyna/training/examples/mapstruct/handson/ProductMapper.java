package com.prodyna.training.examples.mapstruct.handson;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

  ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

  Product toProduct(ProductDto productDto);

  @InheritInverseConfiguration
  ProductDto toDto(Product product);



}
