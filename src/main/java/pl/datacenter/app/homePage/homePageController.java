package pl.datacenter.app.homePage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.datacenter.app.area.Area;
import pl.datacenter.app.area.AreaService;
import pl.datacenter.app.company.Company;
import pl.datacenter.app.company.CompanyService;
import pl.datacenter.app.visit.Visit;
import pl.datacenter.app.visit.VisitService;
import pl.datacenter.app.visitor.Visitor;
import pl.datacenter.app.visitor.VisitorService;

import java.util.List;

@Controller
@RequestMapping("/home")
public class homePageController {

    private final CompanyService companyService;

    private final VisitorService visitorService;

    private final VisitService visitService;

    private final AreaService areaService;
    @Autowired
    public homePageController(CompanyService companyService, VisitorService visitorService, VisitService visitService, AreaService areaService) {
        this.companyService = companyService;
        this.visitorService = visitorService;
        this.visitService = visitService;
        this.areaService = areaService;
    }

    @GetMapping()
    public String home(Model model, Long companyId) {
        List<Company> companies = companyService.findAll();
        List<Visitor> visitors = visitorService.findAllByCompanyId(companyId);
        List<Visit> visitsIn = visitService.findAllWihoutLogOut();
        List<Area> areas = areaService.findAll();
        model.addAttribute("visit", new Visit());
        model.addAttribute("visitsIn", visitsIn);
        model.addAttribute("companies", companies);
        model.addAttribute("visitors", visitors);
        model.addAttribute("areas", areas);
        return "home";
    }

    @PostMapping
    public String addVisit(@ModelAttribute Visit visit) {
        visitService.create(visit);
        return "redirect:/home";
    }

    @GetMapping(value = "/{companyId}", produces = "aplication/json;charset=UTF-8")
    @ResponseBody
    public String visitorsList(@PathVariable Long companyId) throws JsonProcessingException {
        List<Visitor> visitors = visitorService.findAllByCompanyId(companyId);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(visitors);
        return json;
    }

}
