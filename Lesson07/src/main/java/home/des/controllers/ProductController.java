package home.des.controllers;


import home.des.domain.Product;
import home.des.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @ModelAttribute("products")
    public List<Product> products() {
        return productService.getAll();
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "My message for enterprise " + UUID.randomUUID().toString());
        model.addAttribute("title", "Spring Lv1");
        return "index";
    }

    @GetMapping("/products")
    public String productList(Model model){
        model.addAttribute("product", new Product());
        return "productList";
    }

    @PostMapping("/products")
    public String addProduct(Product productForm){
        System.out.println("Request contains user -> " + productForm.toString());
        productService.save(new Product(null, productForm.getTitle(), productForm.getPrice()));
        return "redirect:/products";
    }

    @PostMapping("/productsFilter")
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
