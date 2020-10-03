package home.des.controllers;


import home.des.domain.Product;
import home.des.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String productList(Model model){
        model.addAttribute("products", productService.getAll());
        return "productList";
    }

    @PostMapping("/")
    public String addProduct(Product productForm){
        System.out.println("Request contains product -> " + productForm.toString());
        productService.save(new Product(null, productForm.getPrice(), productForm.getTitle()));
        return "redirect:/products";
    }

    @PostMapping("/product")
    public String updateProduct(Product productForm){
        if (productForm.getPrice() != null && productForm.getTitle() != null) {
            System.out.println("Update contains product" + productForm.toString());
            productService.save(productForm);
        } else System.out.println("Update contains product failed \nGetPrice: " + productForm.getPrice() +
                "\nGetTitle: " + productForm.getTitle());
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String getById(Model model, @PathVariable Long id){
        Product product = productService.getById(id);
        model.addAttribute("product", product == null ? new Product() : product);
        return "product";
    }

}
