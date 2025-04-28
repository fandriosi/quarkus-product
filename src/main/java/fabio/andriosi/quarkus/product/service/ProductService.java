package fabio.andriosi.quarkus.product.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import fabio.andriosi.quarkus.product.dto.ProductDTO;
import fabio.andriosi.quarkus.product.entity.Product;
import fabio.andriosi.quarkus.product.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProductService {

    @Inject
    private ProductRepository repository;
    
    @Inject
    private ProductMapper mapper;

    public List<ProductDTO> findAll(){
        List<ProductDTO> result = new ArrayList<>();
        repository.findAll().stream().forEach(item ->{
            result.add(mapper.toDto(item));
        });
        return result;
    }

    public void create(ProductDTO dto){
        repository.persist(mapper.toEntity(dto));
    }

    public void update(UUID id, ProductDTO dto){
        Product product = repository.findById(id)
            .orElseGet(() ->{
                Product newProduct = new Product();
                newProduct.setId(id);
                return newProduct; 
        });

        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCategoria(dto.getCategoria());
        product.setModel(dto.getModel());
        product.setPrice(dto.getPrice());

        repository.persist(product);
    }

    public boolean delete(UUID id){
        return repository.deleteByUuid(id);
    }
}
