package com.prodyna.training.examples.mapstruct.handson;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {
    ProductMapper.class,
    ProductMapperImpl.class,
    BrandMapper.class,
    BrandMapperImpl.class
})
public class BrandMapperTest {

  @Autowired
  BrandMapper brandMapper;

  @Test
  public void testMapEntityToDto() {

    Brand brand = Brand.builder().id(1).name("Audi").products(
        Lists.newArrayList(
            Product.builder().id(11).description("a4").onSale(true).build(),
            Product.builder().id(12).description("a5").onSale(false).build()
        )
    ).build();

    BrandDto brandDto = brandMapper.toDto(brand);

    assertThat(brandDto.getBrandId(), equalTo("1"));
    assertThat(brandDto.getBrandName(), equalTo("Audi"));
    assertThat(brandDto.getOffersProducts(),
        hasItem(ProductDto.builder().id(11).description("a4").onSale(true).build()));


  }

  @Test
  public void testConvertEntityToDtoAndBack(){

    Brand brand = Brand.builder().id(1).name("Audi").products(
        Lists.newArrayList(
            Product.builder().id(11).description("a4").onSale(true).build(),
            Product.builder().id(12).description("a5").onSale(false).build()
        )
    ).build();

    BrandDto brandDto = brandMapper.toDto(brand);
    Brand brandConverted = brandMapper.toBrand(brandDto);

    assertThat(brand, is(equalTo(brandConverted)));

  }

}
