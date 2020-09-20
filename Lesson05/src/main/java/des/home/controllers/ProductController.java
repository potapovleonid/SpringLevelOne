package des.home.controllers;

import des.home.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    private List<Product> products = new ArrayList<>();

    {
        products.add(new Product(1L, "Bread", 15.25F));
        products.add(new Product(2L, "Butter", 16.35F));
        products.add(new Product(3L, "Apple", 5.05F));
    }


    @ModelAttribute("products")
    public List<Product> products() {
        return products;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "My message for enterprise " + UUID.randomUUID().toString());
        model.addAttribute("title", "Spring Lv1");
        model.addAttribute("user", new Product(4L, "Orange", 25.25F));
        return "index";
    }

    @GetMapping("/products")
    public String productList(Model model){
        model.addAttribute("product", new Product());
        return "productList";
    }

    @PostMapping("/products")
    public String addUser(Product productForm){
        System.out.println("Request contains user -> " + productForm.toString());
        return "redirect:/products";
    }
}
