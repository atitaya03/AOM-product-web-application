package ku.cs.aom_product.model;


import lombok.Data;

import java.util.UUID;

@Data
public class MocaRequest {
    private UUID id;
    private double volume;
}
