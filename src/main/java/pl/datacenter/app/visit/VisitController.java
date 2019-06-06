package pl.datacenter.app.visit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/visit")
public class VisitController {


    @Autowired
    private VisitService visitService;


    @GetMapping("/edit/{visitId}")
    public String editVisit(@PathVariable Long visitId, Model model) {
        model.addAttribute("visitOut", visitService.read(visitId));
        return "visitEdit";
    }

    @PostMapping("/edit/{visitId}")
    public String editVisit(@ModelAttribute Visit visit) {
        visitService.update(visit);
        return "redirect: /home";
    }

    @GetMapping("/delete/{visitId}")
    public String deleteVisit(@PathVariable Long visitId) {
        visitService.delete(visitId);
        return "redirect: /home";
    }
}
