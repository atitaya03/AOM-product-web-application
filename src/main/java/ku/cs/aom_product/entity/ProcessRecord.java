package ku.cs.aom_product.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Data
@Entity
public class ProcessRecord {
    @Id
    @GeneratedValue
    private UUID id;

    private Date date;
    private int quantityRecord;


    @ManyToOne
    private Product product;
}
