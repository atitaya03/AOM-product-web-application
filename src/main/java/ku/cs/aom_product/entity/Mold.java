package ku.cs.aom_product.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Mold {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private int quantity;



}
