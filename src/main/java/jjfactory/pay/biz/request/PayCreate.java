package jjfactory.pay.biz.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PayCreate {
    private Long cardId;
    private Long orderId;
    private int balance;

    @Builder
    public PayCreate(Long cardId, Long orderId, int balance) {
        this.cardId = cardId;
        this.orderId = orderId;
        this.balance = balance;
    }
}
