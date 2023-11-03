package ku.cs.aom_product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Moca {
    @Id
    @GeneratedValue
    private UUID id;

    private double volume;


}
