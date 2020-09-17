package des.home.controllers;

import des.home.domain.Product;
import des.home.repositories.ProductJpaDAORepository;
import des.home.settings.AppData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.List;

//@Controller
//@RequestMapping("/products")
public class ProductsController {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppData.class);
    ProductJpaDAORepository daoRepository = context.getBean(ProductJpaDAORepository.class);

//    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        List<Product> products = daoRepository.findAll();
        model.addAttribute("products", products);
        return "allProducts";
    }
}
