package shopcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopcore.entity.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUsername(String username);
}
