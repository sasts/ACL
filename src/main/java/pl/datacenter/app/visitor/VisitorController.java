package pl.datacenter.app.visitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.datacenter.app.company.CompanyService;
import pl.datacenter.app.file.FileService;

import java.util.List;

@Controller
@RequestMapping("/company/visitors/{companyId}")
public class VisitorController {

    private final VisitorService visitorService;

    private final CompanyService companyService;

    private final FileService fileService;

    @Autowired
    public VisitorController(VisitorService visitorService, CompanyService companyService, FileService fileService) {
        this.visitorService = visitorService;
        this.companyService = companyService;
        this.fileService = fileService;
    }

    @GetMapping()
    public String addVisitor(@PathVariable Long companyId, Model model) {
        model.addAttribute("visitor", new Visitor());
        model.addAttribute("company", companyService.readWithVisitors(companyId));
        List<Visitor> visitors = visitorService.findAllByCompanyId(companyId);
        model.addAttribute("visitors", visitors);
        model.addAttribute("files", fileService.findAll());
        return "visitors";
    }

    @PostMapping()
    public String addVisitor(@ModelAttribute Visitor visitor) {
        visitorService.create(visitor);
        Long id = visitor.getCompany().getId();
        return "redirect:/company/visitors/" + id;
    }

    @GetMapping("/edit/{visitorId}")
    public String editVisitor(@PathVariable Long visitorId, @PathVariable Long companyId, Model model) {
        model.addAttribute("visitor", visitorService.read(visitorId));
        model.addAttribute("company", companyService.read(companyId));
        model.addAttribute("files", fileService.findAll());
        return "visitorEdit";
    }

    @PostMapping("/edit/{visitorId}")
    public String editVisitor(@ModelAttribute Visitor visitor) {
        visitorService.update(visitor);
        Long id = visitor.getCompany().getId();
        return "redirect:/company/visitors/" + id;
    }

    @GetMapping("/delete/{visitorId}")
    public String deleteVisitor(@PathVariable Long visitorId) {
        visitorService.delete(visitorId);
        return "redirect:/company/visitors/{companyId}";
    }

    //TODO dodać funkcjonalność dodawania pliku do pracownika z listą dotępu, dodać obsługę formularzy

}
