package ku.cs.aom_product.controller;


import ku.cs.aom_product.common.Status;
import ku.cs.aom_product.entity.Product;
import ku.cs.aom_product.service.DatasheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("datasheetWarehouse")
public class DatasheetWarehouseController {

    @Autowired
    private DatasheetService datasheetService;

    @GetMapping
    public String getAllDataSheet(Model model){
        model.addAttribute("datasheets",datasheetService.getAllWaitingProduct());
        return "datasheet-warehouse";
    }


    @GetMapping("/{id}")
    public String getOneDatasheetForWh(@PathVariable UUID id, Model model){
        Product product = datasheetService.getOneById(id);
        model.addAttribute("product",product);

        return "datasheet-detail-warehouse";
    }

    @PostMapping("/{id}/complete")
    public String complete(@PathVariable UUID id){
        datasheetService.updateStatus(id, Status.พร้อมผลิต);
        return "datasheet-warehouse";
    }

}
