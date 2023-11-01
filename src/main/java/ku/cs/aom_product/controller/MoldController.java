package ku.cs.aom_product.controller;


import ku.cs.aom_product.model.MoldRequest;
import ku.cs.aom_product.service.MoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("molds")
@Controller
public class MoldController {
    @Autowired
    private MoldService moldService;


    @GetMapping
    public String getAllMold(Model model){
        model.addAttribute("molds",moldService.getAllMolds());
        return "mold-all";

    }

    @GetMapping("/add")
    public String getMoldForm(Model model){
        return "mold-add";

    }

    @PostMapping("/add")
    public String allMold(@ModelAttribute MoldRequest request, Model model){
        moldService.addMold(request);
        return "redirect:/molds";

    }


}
