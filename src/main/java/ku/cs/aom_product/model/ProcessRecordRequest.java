package ku.cs.aom_product.model;


import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ProcessRecordRequest {
    private Date date;
    private int quantityRecord;
    private UUID id;
}
