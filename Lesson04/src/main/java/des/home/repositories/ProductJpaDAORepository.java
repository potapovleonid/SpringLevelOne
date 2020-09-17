package des.home.repositories;

import des.home.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface ProductJpaDAORepository extends JpaRepository<Product, Long> {
    List<Product> findAllByTitleLike(String title);
    List<Product> findAllByIdBetween(Long startId, Long endId);
}
