package ku.cs.aom_product.entity;

import jakarta.persistence.*;
import ku.cs.aom_product.common.Status;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private int hardness;
    private int quantity;
    private double volume;
    private double chemicalVolume;
    private double mocaVolume;
    private String shape;
    private Status status;

    @OneToMany(mappedBy = "product")
    private List<ProcessRecord> processRecord;

    @ManyToOne
    private Mold mold;

    @ManyToOne
    private Chemical chemical;



}
