package pl.datacenter.app.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.datacenter.app.company.CompanyService;

import java.util.List;

@Controller
@RequestMapping("/company/visitors/{companyId}")
public class VisitorController {

    private final VisitorService visitorService;

    private final CompanyService companyService;

    @Autowired
    public VisitorController(VisitorService visitorService, CompanyService companyService) {
        this.visitorService = visitorService;
        this.companyService = companyService;
    }

    @GetMapping()
    public String addVisitor(@PathVariable Long companyId, Model model) {
        model.addAttribute("visitor", new Visitor());
        model.addAttribute("company", companyService.read(companyId));
        List<Visitor> visitors = visitorService.findAllByCompanyId(companyId);
        model.addAttribute("visitors", visitors);
        return "visitors";
    }

    @PostMapping()
    public String addVisitor(@ModelAttribute Visitor visitor) {
        visitorService.create(visitor);
        return "redirect:/company/visitors/{companyId}";
    }

    @GetMapping("/edit/{visitorId}")
    public String editVisitor(@PathVariable Long visitorId, @PathVariable Long companyId, Model model) {
        model.addAttribute("visitor", visitorService.read(visitorId));
        model.addAttribute("company", companyService.read(companyId));
        return "visitorEdit";
    }

    @PostMapping("/edit/{visitorId}")
    public String editVisitor(@ModelAttribute Visitor visitor) {
        visitorService.update(visitor);
        return "redirect:/company/visitors/{companyId}";
    }

    @GetMapping("/delete/{visitorId}")
    public String deleteVisitor(@PathVariable Long visitorId) {
        visitorService.delete(visitorId);
        return "redirect:/company/visitors/{companyId}";
    }

    //TODO dodać funkcjonalność dodawania pliku do pracownika z listą dotępu, dodać obsługę formularzy

}
