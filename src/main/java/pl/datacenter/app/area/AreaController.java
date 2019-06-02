package pl.datacenter.app.area;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/areas")
public class AreaController {

    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }


    @ModelAttribute("areas")
    public Collection<Area> areas() {
        List<Area> areas = areaService.findAll();
        return areas;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("area", new Area());
        return "areas";
    }

    @PostMapping
    public String add(@ModelAttribute Area area) {
        areaService.create(area);
        return "redirect:areas";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("area", areaService.read(id));
        return "areaEdit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@ModelAttribute Area area) {
        areaService.update(area);
        return "redirect:/areas";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        areaService.delete(id);
        return "redirect:/areas";
    }
}
