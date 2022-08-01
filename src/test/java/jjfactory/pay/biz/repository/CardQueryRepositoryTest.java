package jjfactory.pay.biz.repository;

import jjfactory.pay.biz.domain.card.Card;
import jjfactory.pay.biz.domain.user.User;
import jjfactory.pay.biz.response.CardResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class CardQueryRepositoryTest {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CardQueryRepository cardQueryRepository;

    @Test
    @DisplayName("유저 아이디로 카드 셀렉트")
    void findCardsByUsername() {
        //given
        User user = User.builder().name("이재형").username("wogud222").build();
        userRepository.save(user);

        Card card1 = Card.builder().user(user).alias("재형이의 카드1").build();
        Card card2 = Card.builder().user(user).alias("재형이의 카드2").build();
        Card card3 = Card.builder().user(user).alias("재형이의 카드3").build();
        cardRepository.save(card1);
        cardRepository.save(card2);
        cardRepository.save(card3);

        //when
        card3.delete();
        List<CardResponse> cards = cardQueryRepository.findCardsByUsername("wogud222");
        List<String> aliasList = cards.stream().map(c -> c.getAlias()).collect(Collectors.toList());

        //then
        assertThat(aliasList).containsExactly("재형이의 카드1","재형이의 카드2");
    }

}