package des.home;

import des.home.domain.Product;
import des.home.repositories.ProductJpaDAORepository;
import des.home.services.ProductServiceImpl;
import des.home.settings.AppData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppData.class);

        ProductJpaDAORepository daoRepository = context.getBean(ProductJpaDAORepository.class);

        Product product = new Product("Butter", 15.25);
        List<Product> products = Arrays.asList(product);
        daoRepository.saveAll(products);
    }

}
