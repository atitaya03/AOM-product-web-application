package ku.cs.aom_product.model;

import lombok.Data;

@Data
public class ChemicalRequest {
    private String name;

    private double ovenTime;
    private double solidTime;
    private double volume;
    private int hardness;
}
