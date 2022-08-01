package jjfactory.pay.biz.service;


import jjfactory.pay.biz.domain.card.Card;
import jjfactory.pay.biz.domain.user.User;
import jjfactory.pay.biz.repository.CardQueryRepository;
import jjfactory.pay.biz.repository.CardRepository;
import jjfactory.pay.biz.repository.UserRepository;
import jjfactory.pay.biz.request.CardCreate;
import jjfactory.pay.biz.request.CardUpdate;
import jjfactory.pay.biz.response.CardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
@Transactional
public class CardService {
    private final CardQueryRepository cardQueryRepository;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<CardResponse> findCardsByUsername(String username){
        return cardQueryRepository.findCardsByUsername(username);
    }

    public String create(CardCreate dto){
        User user = getUser(dto.getUserId());
        Card card = Card.create(dto, user);
        cardRepository.save(card);
        return "Y";
    }

    public String modify(Long cardId, CardUpdate dto){
        Card card = getCard(cardId);
        card.modifyAlias(dto.getAlias());
        return "Y";
    }

    public String delete(Long cardId){
        Card card = getCard(cardId);
        card.delete();
        return "Y";
    }

    private User getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        return user;
    }

    private Card getCard(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(NoSuchElementException::new);
        return card;
    }
}
