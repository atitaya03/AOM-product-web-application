package ku.cs.aom_product.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Hardness {
    @Id
    @GeneratedValue
    private int hardness;

    @OneToMany(mappedBy = "hardness")
    private List<Chemical> chemicals;
}
