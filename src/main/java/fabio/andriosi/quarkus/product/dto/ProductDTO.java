package fabio.andriosi.quarkus.product.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    public UUID id;
    private String name;
    private String description;
    private String categoria;
    private String model;
    private Double price;
    private Integer estoque;
}
