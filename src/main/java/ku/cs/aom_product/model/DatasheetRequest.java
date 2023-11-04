package ku.cs.aom_product.model;

import ku.cs.aom_product.common.Status;

import lombok.Data;

import java.util.UUID;

@Data
public class DatasheetRequest {
    private String name;
    private int hardness;
    private int quantity;
    private double volume;
    private double chemicalVolume;
    private double mocaVolume;
    private String shape;
    private Status status;

    private UUID moldId;
    private String chemicalName;
}
