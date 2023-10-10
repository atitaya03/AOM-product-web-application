package ku.cs.aom_product.model;

import ku.cs.aom_product.common.Status;
import ku.cs.aom_product.shape.Shape;
import lombok.Data;

import java.util.UUID;

@Data
public class DatasheetRequest {
    private int name;
    private int hardness;
    private String shape;
    private UUID moldId;
}
