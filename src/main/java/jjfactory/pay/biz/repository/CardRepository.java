package jjfactory.pay.biz.repository;

import jjfactory.pay.biz.domain.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card,Long> {
}
