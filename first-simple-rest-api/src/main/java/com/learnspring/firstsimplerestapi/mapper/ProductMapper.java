package com.learnspring.firstsimplerestapi.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.learnspring.firstsimplerestapi.domain.Product;
import com.learnspring.firstsimplerestapi.dto.ProductDto;

@Mapper
public interface ProductMapper {
  
  ProductMapper MAPPER = Mappers.getMapper(ProductMapper.class);
  
  Product toProduct(ProductDto dto);
  
  @InheritInverseConfiguration
  ProductDto fromProduct(Product p);
  
  List<Product> toProductList(List<ProductDto> dtoList);

  List<ProductDto> fromProductList(List<Product> productList);

}
