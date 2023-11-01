package ku.cs.aom_product.controller;

import ku.cs.aom_product.entity.Chemical;
import ku.cs.aom_product.model.DatasheetRequest;
import ku.cs.aom_product.service.ChemicalService;
import ku.cs.aom_product.service.DatasheetService;
import ku.cs.aom_product.service.HardnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/datasheets")
public class DatasheetController {

    @Autowired
    private DatasheetService datasheetService;
    @Autowired
    private HardnessService hardnessService;

    @Autowired
    private ChemicalService chemicalService;

    @GetMapping
    public String getAllDataSheet(Model model){
        model.addAttribute("datasheets",datasheetService.getAllProduct());
        return "datasheet-all";
    }

    @GetMapping("create")
    public String getDataSheetForm(Model model){
        List<String> shapeOptions = Arrays.asList("สี่เหลี่ยม", "แท่งตัน", "แท่งมีรู");
        model.addAttribute("shapeOptions",shapeOptions );
        model.addAttribute("hardnessList",hardnessService.getAllHardness());
        model.addAttribute("chemicals",chemicalService.getAllChemicals());
        return "datasheet-create";
    }



    @PostMapping("create")
    public String createDataSheet(@ModelAttribute DatasheetRequest request, Model model){
        datasheetService.createDataSheet(request);
        return "redirect:/datasheets";
    }

}
