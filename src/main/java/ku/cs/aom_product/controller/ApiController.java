package ku.cs.aom_product.controller;
import ku.cs.aom_product.entity.Chemical;
import ku.cs.aom_product.entity.Hardness;
import ku.cs.aom_product.entity.Mold;

import ku.cs.aom_product.model.MocaRequest;
import ku.cs.aom_product.model.UpdateChemicalRequest;
import ku.cs.aom_product.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private ChemicalService chemicalService;

    @Autowired
    private HardnessService hardnessService;

    @Autowired
    private MoldService moldService;

    @Autowired
    private MocaService mocaService;

    @GetMapping("/chemicals/{hardness}")
    public List<Chemical> getChemical(@PathVariable int hardness) {
        List<Chemical> chemicalList =  chemicalService.getChemicalsByHardness(hardness);
        return  chemicalList;
    }

    @PutMapping("/chemicals/{name}/use")
    public void useChemical(@PathVariable String name, @ModelAttribute UpdateChemicalRequest request, Model model) {
        chemicalService.useChemical(name,request);
    }

    @PutMapping("/moca/use")
    public void useChemical(@ModelAttribute MocaRequest request, Model model) {
        mocaService.use(request);
    }

    @GetMapping("/hardness")
    public List<Hardness> getAllHardness() {
        List<Hardness> hardnessList =  hardnessService.getAllHardness();
        return  hardnessList;
    }

    @GetMapping("/mold")
    public List<Mold> getAllMold() {
        List<Mold> moldList =  moldService.getAllMolds();
        return  moldList;
    }

    @GetMapping("/moca")
    public double getVolumeMoca() {
        Double volume =  mocaService.getVolume();
        return  volume;
    }
}
