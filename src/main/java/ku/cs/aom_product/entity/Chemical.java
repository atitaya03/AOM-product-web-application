package ku.cs.aom_product.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @ManyToOne
    private Hardness hardness;




}
