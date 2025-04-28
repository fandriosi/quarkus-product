package fabio.andriosi.quarkus.product.service;

import java.util.List;

import org.mapstruct.Mapper;

import fabio.andriosi.quarkus.product.dto.ProductDTO;
import fabio.andriosi.quarkus.product.entity.Product;

@Mapper(componentModel = "cdi")
public interface ProductMapper{
    
    ProductDTO toDto(Product product);

    List<ProductDTO> toDtoList(List<Product> customers);

    Product toEntity(ProductDTO dto);
}
