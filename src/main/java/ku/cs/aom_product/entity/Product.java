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

    private int name;
    private double height;
    private int width;
    private int hardness;
    private Status status;

    @OneToMany(mappedBy = "product")
    private List<ProcessRecord> processRecord;

    @OneToOne
    private Mold mold;
}
