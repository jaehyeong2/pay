package jjfactory.pay.biz.service;

import jjfactory.pay.biz.domain.card.Card;
import jjfactory.pay.biz.domain.shop.Order;
import jjfactory.pay.biz.domain.user.User;
import jjfactory.pay.biz.repository.CardRepository;
import jjfactory.pay.biz.repository.OrderRepository;
import jjfactory.pay.biz.repository.PayRepository;
import jjfactory.pay.biz.repository.UserRepository;
import jjfactory.pay.biz.request.PayCreate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PayServiceTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    CardRepository cardRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PayRepository payRepository;

    @Autowired
    PayService payService;


    //TODO 오더가 없는 말이안되는 상태
    @Test
    void create() {
        //given
        User lee = User.builder().name("lee").build();
        userRepository.save(lee);

        Card card = Card.builder().user(lee).alias("재형이의 카드").build();
        cardRepository.save(card);

        Order order = Order.builder().card(card).build();
        orderRepository.save(order);

        PayCreate pay = PayCreate.builder().balance(10000)
                .cardId(card.getId()).orderId(order.getId()).build();

        //when
        payService.create(pay);

        //then
        assertThat(payRepository.count()).isEqualTo(1);
    }
}