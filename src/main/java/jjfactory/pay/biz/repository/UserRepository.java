package jjfactory.pay.biz.repository;

import jjfactory.pay.biz.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
