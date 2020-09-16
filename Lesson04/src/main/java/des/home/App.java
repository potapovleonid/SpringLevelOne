package des.home;

import des.home.services.ProductServiceImpl;
import des.home.settings.AppData;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppData.class);

        ProductServiceImpl productService = context.getBean(ProductServiceImpl.class);



    }

}
