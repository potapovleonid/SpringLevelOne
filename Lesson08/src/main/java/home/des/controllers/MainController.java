package home.des.controllers;

import home.des.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class MainController {

    ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = {"","/"})
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login")
    public String loginPage(){
        return "login";
    }

    @PostMapping("/filter")
    public String filter(@RequestParam(name = "startFilter") Double startFilter,
                         @RequestParam(name = "endFilter") Double endFilter){
        String filter = "";
        if ((endFilter == null && startFilter == null) || startFilter == null){
            return "redirect:/products";
        }
        if (endFilter == null){
            filter = "redirect:/filter?price_from=" + startFilter + "&priceTo=" + Double.MAX_VALUE;
            return filter;
        } else {
            filter = "redirect:/filter?price_from=" + startFilter + "&priceTo=" + endFilter;
            return filter;
        }
    }


    //     http://localhost:8080/app/filter?price_from=35.4&priceTo=3
    @GetMapping("/filter")
    public String filterByPrice(Model model,
                                @RequestParam(name = "price_from") double priceFrom,
                                @RequestParam(required = false) Double priceTo){
        model.addAttribute("products", productService.getByPrice(priceFrom, priceTo));
        return "filterList";
    }
}
