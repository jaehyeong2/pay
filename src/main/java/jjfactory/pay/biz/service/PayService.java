package jjfactory.pay.biz.service;


import jjfactory.pay.biz.domain.card.Card;
import jjfactory.pay.biz.domain.pay.PayTry;
import jjfactory.pay.biz.domain.shop.Order;
import jjfactory.pay.biz.repository.CardRepository;
import jjfactory.pay.biz.repository.OrderRepository;
import jjfactory.pay.biz.repository.PayRepository;
import jjfactory.pay.biz.request.PayCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class PayService {
    private final PayRepository payRepository;
    private final CardRepository cardRepository;
    private final OrderRepository orderRepository;

    public String create(PayCreate dto){
        Card card = getCard(dto.getCardId());
        Order order = getOrder(dto.getOrderId());
        PayTry payTry = PayTry.create(dto, card, order);
        payRepository.save(payTry);

        return "Y";
    }

    public String delete(Long payId){
        PayTry pay = getPay(payId);
        pay.delete();
        return "Y";
    }

    //todo 삭제만 있는게 아니라 취소도 잇어야하지않음?

    private PayTry getPay(Long payId) {
        PayTry pay = payRepository.findById(payId).orElseThrow(NoSuchElementException::new);
        return pay;
    }
    private Card getCard(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(NoSuchElementException::new);
        return card;
    }

    private Order getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new);
        return order;
    }
}
