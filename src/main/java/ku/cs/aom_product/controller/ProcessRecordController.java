package ku.cs.aom_product.controller;

import ku.cs.aom_product.common.Status;
import ku.cs.aom_product.entity.Product;
import ku.cs.aom_product.model.DatasheetRequest;
import ku.cs.aom_product.model.ProcessRecordRequest;
import ku.cs.aom_product.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/processRecords")
public class ProcessRecordController {


    @Autowired
    private ProcessRecordService processRecordService;
    @Autowired
    private DatasheetService datasheetService;


        @PostMapping("/{id}")
        public String createProcessRecord(@PathVariable UUID id, Model model, @ModelAttribute ProcessRecordRequest request){
            datasheetService.updateStatus(id,Status.ระหว่างการผลิต);
            processRecordService.createProcessRecord(request);
            return "redirect:/datasheets";
        }



}
