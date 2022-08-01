package jjfactory.pay.biz.response;

import jjfactory.pay.biz.domain.card.Card;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CardResponse {
    private Long userId;
    private String username;
    private String cardNumber;
    private String alias;
    private String bankCode;

    @Builder
    public CardResponse(Long userId, String username, String cardNumber, String alias, String bankCode) {
        this.userId = userId;
        this.username = username;
        this.cardNumber = cardNumber;
        this.alias = alias;
        this.bankCode = bankCode;
    }

    public CardResponse(Card card) {
        this.userId = card.getUser().getId();
        this.username = card.getUser().getName();
        this.cardNumber = card.getCardNumber();
        this.alias = card.getAlias();
        this.bankCode = bankCode;
    }
}
