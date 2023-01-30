package shopcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopcore.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
