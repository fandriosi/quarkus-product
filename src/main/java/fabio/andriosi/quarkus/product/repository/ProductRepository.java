package fabio.andriosi.quarkus.product.repository;

import java.util.Optional;
import java.util.UUID;

import fabio.andriosi.quarkus.product.entity.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductRepository implements  PanacheRepository<Product>{
    
    public Optional<Product> findById(UUID id) {
        return find("id", id).firstResultOptional();
    }

    public boolean deleteByUuid(UUID id) {
        return delete("id = :id", Parameters.with("id", id)) > 0;
    }
}
