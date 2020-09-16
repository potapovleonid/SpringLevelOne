package des.home.controllers;

import des.home.domain.Product;
import des.home.service.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    //products
//    @RequestMapping(method = RequestMethod.GET)
//    public String list(Model model){
//        List<Product> products = productService.getProducts();
//        model.addAttribute("products", products);
//        return "allProducts";
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getById(Model model, @PathVariable("id") Long id){
        Product product = productService.getById(id);
        model.addAttribute("product",
                product == null ? new Product(): product);
        return "product";
    }

    @RequestMapping(value = "/{id}/price", method = RequestMethod.GET)
    @ResponseBody
    public String apiPrice(@PathVariable Long id){
        Product product = productService.getById(id);
        return String.valueOf(product == null ? null : product.getPrice() );
    }

    @GetMapping("/new")
    public String getFormNewProduct(Model model){
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addNewProduct(Product product){
        Product tmpProduct = productService.save(product);
        System.out.println(tmpProduct);
        return "redirect:/products/" + tmpProduct.getId();
    }

    @RequestMapping(value = "any")
    @ResponseBody
    public String anyRequest(){
        return "any request" + UUID.randomUUID().toString();
    }

    @GetMapping(params = {"price_form", "price_to"})
    public String productsByPrice(Model model,
                                  @RequestParam(name = "price_form") double priceForm,
                                  @RequestParam double priceTo){
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "allProducts";
    }

    @GetMapping("/filter")
    public String filterByPrice(Model model,
                                @RequestParam(name = "price_form") double priceForm,
                                @RequestParam(required = false) Double priceTo){
        List<Product> products = productService.
                getByPrice(priceForm, priceTo == null ? Double.MAX_VALUE : priceTo);
        model.addAttribute("products", products);
        return "allProducts";
    }

    @PostMapping("/filter")
    @ResponseBody
    public String filterByTitle(@RequestParam String name){
        return productService.getProducts().stream()
                .filter(product -> product.getName().contains(name))
                .map(product -> String.valueOf(product.getId()))
                .collect(Collectors.joining(","));
    }
}
