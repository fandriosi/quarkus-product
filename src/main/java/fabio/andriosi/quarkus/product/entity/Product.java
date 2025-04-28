package fabio.andriosi.quarkus.product.entity;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class Product {
    @Id    
    @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private String categoria;
    private String model;
    private Double price;
}
