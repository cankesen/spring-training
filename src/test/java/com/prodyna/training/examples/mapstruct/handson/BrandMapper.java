package com.prodyna.training.examples.mapstruct.handson;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {ProductMapper.class}, componentModel = "spring")
public interface BrandMapper {

  BrandMapper INSTANCE = Mappers.getMapper(BrandMapper.class);

  @Mapping(source = "brandId", target = "id", resultType = Integer.class)
  @Mapping(source = "brandName", target = "name")
  @Mapping(source = "offersProducts", target = "products")
  Brand toBrand(BrandDto brandDto);

  @InheritInverseConfiguration
  BrandDto toDto(Brand brand);

}
