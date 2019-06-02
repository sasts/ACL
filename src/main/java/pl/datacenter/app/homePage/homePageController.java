package pl.datacenter.app.homePage;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.datacenter.app.company.Company;
import pl.datacenter.app.company.CompanyService;
import pl.datacenter.app.visit.Visit;
import pl.datacenter.app.visitor.Visitor;
import pl.datacenter.app.visitor.VisitorService;

import java.util.List;

@Controller
@RequestMapping("/home")
public class homePageController {

    private final CompanyService companyService;

    private final VisitorService visitorService;

    @Autowired
    public homePageController(CompanyService companyService, VisitorService visitorService) {
        this.companyService = companyService;
        this.visitorService = visitorService;
    }

    @GetMapping()
    public String home(Model model, Long companyId) {
        List<Company> companies = companyService.findAll();
        List<Visitor> visitors = visitorService.findAllByCompanyId(companyId);
        model.addAttribute("visit", new Visit());
        model.addAttribute("companies", companies);
        model.addAttribute("visitors", visitors);
        return "home";
    }

    @GetMapping("/{companyId}")
    public ModelAndView visitorsList(@PathVariable Long companyId){
        Gson gson = new Gson();
        String json = gson.toJson(visitorService.findAllByCompanyId(companyId));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(json);
        return modelAndView;
    }











}
