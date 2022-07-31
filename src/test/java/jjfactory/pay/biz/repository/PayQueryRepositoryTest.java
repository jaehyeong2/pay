package jjfactory.pay.biz.repository;

import jjfactory.pay.biz.domain.card.Card;
import jjfactory.pay.biz.domain.pay.PayTry;
import jjfactory.pay.biz.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
class PayQueryRepositoryTest {

    @Autowired
    PayQueryRepository payQueryRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PayRepository payRepository;
    @Autowired
    CardRepository cardRepository;

    @Test
    void findTotalPayAmountByCard() {
        //given
        User wogud = User.builder().username("wogud2").name("이재형").build();
        userRepository.save(wogud);

        Card card = Card.builder().user(wogud).build();
        cardRepository.save(card);

        for (int i = 0; i < 10; i++) {
            PayTry success = PayTry.builder().card(card).balance(30000).success(true).build();
            PayTry failed = PayTry.builder().card(card).balance(30000).success(false).build();

            payRepository.save(success);
            payRepository.save(failed);
        }

        //when
        Integer totalPayAmount = payQueryRepository.findTotalPayAmountByCardId(card.getId());

        assertThat(totalPayAmount).isEqualTo(300000);
    }
}