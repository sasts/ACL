package pl.datacenter.app.homePage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class homePageController {

    @GetMapping
    public String home() {
        return "home";
    }


}
