package ku.cs.aom_product.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Chemical {
    @Id
    private String name;

    private double ovenTime;
    private double solidTime;
    private double volume;

    @ManyToOne
    private Hardness hardness;




}
