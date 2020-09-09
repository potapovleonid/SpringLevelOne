package des.home.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Controller
public class WebControllers {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("message", "Bloody enterprise" + UUID.randomUUID());
        return "index";
    }
}
