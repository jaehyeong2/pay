package jjfactory.pay.biz.domain.shop;

import jjfactory.pay.biz.domain.BaseTimeEntity;
import jjfactory.pay.biz.domain.card.Card;
import jjfactory.pay.biz.domain.user.User;
import jjfactory.pay.biz.request.OrderCreate;
import jjfactory.pay.biz.service.OrderService;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "orders")
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "card_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Card card;

    @Builder
    public Order(Card card) {
        this.card = card;
    }

    public static Order create(Card card){
        return Order.builder()
                .card(card)
                .build();
    }
}
