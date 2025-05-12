package fabio.andriosi.quarkus.product.dto;

import java.util.List;
import java.util.UUID;

public class OrderDTO {
    public UUID id;
    public UUID consumidorId;
    public List<ProductOrderDTO> produtos;
}