package des.home.repositories;

import com.sun.xml.bind.v2.model.core.ID;
import des.home.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByTitleLike(String title);
    List<Product> findAllByIdBetween(Long startId, Long endId);
}
