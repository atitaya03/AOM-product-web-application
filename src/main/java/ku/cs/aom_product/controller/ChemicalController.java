package ku.cs.aom_product.controller;


import ku.cs.aom_product.model.ChemicalRequest;
import ku.cs.aom_product.model.UpdateChemicalRequest;
import ku.cs.aom_product.service.ChemicalService;
import ku.cs.aom_product.service.HardnessService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/chemicals")
public class ChemicalController {

    @Autowired
    private ChemicalService chemicalService;

    @Autowired
    private HardnessService hardnessService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public String getAllChemicals(Model model) {
        model.addAttribute("chemicals",chemicalService.getAllChemicals());
        return "chemical-view";
    }

    @GetMapping("/create")
    public String getChemicalForm(Model model) {
        model.addAttribute("hardnessList",hardnessService.getAllHardness());
        return "chemical-create";
    }

    @PostMapping("/create")
    public String createChemical(@ModelAttribute ChemicalRequest request, Model model) {

        chemicalService.createChemical(request);
        return "redirect:/chemicals";
    }


}
