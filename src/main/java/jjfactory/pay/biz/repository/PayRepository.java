package jjfactory.pay.biz.repository;

import jjfactory.pay.biz.domain.pay.PayTry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayRepository extends JpaRepository<PayTry,Long> {
}
