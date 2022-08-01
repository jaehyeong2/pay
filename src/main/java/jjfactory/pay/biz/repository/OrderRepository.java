package jjfactory.pay.biz.repository;

import jjfactory.pay.biz.domain.shop.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
