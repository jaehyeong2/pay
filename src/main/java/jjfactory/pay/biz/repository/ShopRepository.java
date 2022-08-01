package jjfactory.pay.biz.repository;

import jjfactory.pay.biz.domain.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,Long> {
}
