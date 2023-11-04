package ku.cs.aom_product.controller;


import ku.cs.aom_product.service.DatasheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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



    @PutMapping("/update-status")
    public String updateStatus(){

        return "datasheet-warehouse";
    }

}
