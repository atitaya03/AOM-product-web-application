package ku.cs.aom_product.controller;

import ku.cs.aom_product.entity.Chemical;
import ku.cs.aom_product.model.DatasheetRequest;
import ku.cs.aom_product.service.ChemicalService;
import ku.cs.aom_product.service.DatasheetService;
import ku.cs.aom_product.service.HardnessService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/findByHardness")
    public List<Chemical> findByHardness(@RequestParam int hardness) {
        return chemicalService.getChemicalsByHardness(hardness);
    }
    @GetMapping("create")
    public String getDataSheetForm(Model model){
        List<String> shapeOptions = Arrays.asList("Circle", "Sphere", "Cube");
        model.addAttribute("shapeOptions",shapeOptions );
        model.addAttribute("hardnessList",hardnessService.getAllHardness());
        model.addAttribute("chemicalList",chemicalService.getAllChemicals());
        return "datasheet-create";
    }



    @PostMapping("create")
    public String createDataSheet(@ModelAttribute DatasheetRequest request, Model model){
        datasheetService.createDataSheet(request);
        return "redirect:/datasheets";
    }

}