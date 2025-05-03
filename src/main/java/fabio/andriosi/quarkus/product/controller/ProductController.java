package fabio.andriosi.quarkus.product.controller;

import java.util.List;
import java.util.UUID;

import fabio.andriosi.quarkus.product.dto.ProductDTO;
import fabio.andriosi.quarkus.product.service.ProductService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api-v1/product")
public class ProductController {

    @Inject
    private ProductService service;

    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDTO> findAll(){
        return service.findAll();
    }

    @POST
    @Transactional
    public Response create(ProductDTO dto){
        try{
            service.create(dto);
            return Response.ok().build();
        }catch(Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") UUID Id, ProductDTO dto){
        try{
            service.update(Id, dto);
            return Response.accepted().build();
        }catch(Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") UUID id){
        try{
            service.delete(id);
            return Response.accepted().build();
        }catch(Exception e){
            e.printStackTrace();
            return Response.serverError().build();
        }
    }
}
