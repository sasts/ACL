package pl.datacenter.app.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @ModelAttribute("companies")
    public Collection<Company> companies() {
        List<Company> companies = companyService.findAll();
        return companies;
    }

    @GetMapping()
    public String list(Model model){
        model.addAttribute("company", new Company());
        return "companies";
    }

    @PostMapping()
    public String add(@ModelAttribute("company") @Valid Company company, BindingResult result){
        if(result.hasErrors()){
            return "companies";
        }
        companyService.create(company);
        return "redirect:/company";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("company", companyService.read(id));
        return "companyEdit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute("company") Company company, BindingResult result) {
        if(result.hasErrors()) {
            return "companyEdit";
        }
        companyService.update(company);
        return "redirect:/company";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        companyService.delete(id);
        return "redirect:/company";
    }


}
