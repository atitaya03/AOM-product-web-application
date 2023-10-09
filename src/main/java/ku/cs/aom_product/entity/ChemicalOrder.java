package ku.cs.aom_product.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class ChemicalOrder {
    @Id
    @GeneratedValue
    private UUID id;

    private double volume;



    @ManyToOne
    private Chemical chemical;
    @OneToOne
    private Product product;
}
