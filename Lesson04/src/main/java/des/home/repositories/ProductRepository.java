package des.home.repositories;

import com.sun.xml.bind.v2.model.core.ID;
import des.home.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
