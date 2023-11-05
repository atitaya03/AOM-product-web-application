package ku.cs.aom_product.controller;

import ku.cs.aom_product.common.Status;
import ku.cs.aom_product.entity.Chemical;
import ku.cs.aom_product.entity.ProcessRecord;
import ku.cs.aom_product.entity.Product;
import ku.cs.aom_product.model.DatasheetRequest;
import ku.cs.aom_product.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/datasheets")
public class DatasheetController {
    @Autowired
    private MocaService mocaService;

    @Autowired
    private DatasheetService datasheetService;

    @Autowired
    private ProcessRecordService processRecordService;
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
        model.addAttribute("hardnessList",hardnessService.getAllHardness());
        model.addAttribute("chemicals",chemicalService.getAllChemicals());
        return "datasheet-create";
    }


    @PostMapping("create")
    public String createDataSheet(@RequestParam("action") String action,@ModelAttribute DatasheetRequest request, Model model){
        if ("submit1".equals(action)) {
           request.setStatus(Status.พร้อมผลิต);
            mocaService.use(request.getMocaVolume());
            chemicalService.useChemical(request.getChemicalName(),request.getChemicalVolume());
        } else if ("submit2".equals(action)) {
            request.setStatus(Status.รอน้ำยา);
        }
        datasheetService.createDataSheet(request);
        return "redirect:/datasheets";
    }

    @GetMapping("/{id}")
    public String getOneDatasheet(@PathVariable UUID id, Model model){
        Product product = datasheetService.getOneById(id);
        List<ProcessRecord> processRecordList = processRecordService.getProcessRecordByProductId(id);
        int sumProdeced = processRecordService.getProducedProcessRecordByProductId(id);
        model.addAttribute("product",product);
        model.addAttribute("processes",processRecordList);
        model.addAttribute("sumProduced",sumProdeced);
        return "datasheet-detail";
    }



    @PostMapping("/{id}/produce")
    public String produce(@PathVariable UUID id){
        datasheetService.updateStatus(id,Status.ระหว่างการผลิต);
        return "redirect:/datasheets";
    }



    @PostMapping("/{id}/producefinish")
    public String finishProduct(@PathVariable UUID id){
        datasheetService.updateStatus(id,Status.ผลิตสำเร็จ);
        return "redirect:/datasheets";
    }


}
