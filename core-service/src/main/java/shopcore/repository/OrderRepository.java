package shopcore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shopcore.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
