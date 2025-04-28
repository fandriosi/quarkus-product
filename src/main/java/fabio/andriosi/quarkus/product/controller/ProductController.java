package fabio.andriosi.quarkus.product.controller;

import java.util.List;

import fabio.andriosi.quarkus.product.dto.ProductDTO;
import fabio.andriosi.quarkus.product.service.ProductService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/api-v1/product")
public class ProductController {

    @Inject
    private ProductService service;

    
    @GET
    public List<ProductDTO> findAll(){
        return service.findAll();
    }

}
