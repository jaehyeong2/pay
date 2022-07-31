package jjfactory.pay.biz.domain.pay;

import jjfactory.pay.biz.domain.card.Card;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class PayTry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "card_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Card card;
    private int balance;
    private Boolean success;

    @Builder
    public PayTry(Card card, int balance, Boolean success) {
        this.card = card;
        this.balance = balance;
        this.success = success;
    }
}
