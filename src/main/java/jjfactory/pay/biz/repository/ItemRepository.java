package jjfactory.pay.biz.repository;

import jjfactory.pay.biz.domain.shop.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,Long> {
}
