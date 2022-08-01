package jjfactory.pay.biz.domain.pay;

import jjfactory.pay.biz.domain.BaseTimeEntity;
import jjfactory.pay.biz.domain.card.Card;
import jjfactory.pay.biz.domain.shop.Order;
import jjfactory.pay.biz.request.PayCreate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class PayTry extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JoinColumn(name = "card_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Card card;

    @JoinColumn(name = "order_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Order order;
    private int balance;
    private Boolean success;

    @Builder
    public PayTry(Card card, Order order, int balance, Boolean success) {
        this.card = card;
        this.order = order;
        this.balance = balance;
        this.success = success;
    }

    public static PayTry create(PayCreate dto,Card card,Order order){
        return PayTry.builder()
                .balance(dto.getBalance())
                .card(card)
                .order(order)
                .success(true)
                .build();
    }
}
