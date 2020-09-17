package des.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class WebController {

//    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "Hello guys");
        return "index";
    }
}
