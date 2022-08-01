package jjfactory.pay.biz.repository;

import jjfactory.pay.biz.domain.shop.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
