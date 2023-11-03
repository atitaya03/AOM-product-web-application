package ku.cs.aom_product.controller;
import ku.cs.aom_product.entity.Chemical;
import ku.cs.aom_product.entity.Hardness;
import ku.cs.aom_product.entity.Mold;

import ku.cs.aom_product.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
