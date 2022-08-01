package jjfactory.pay.biz.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CardCreate {
    private Long userId;
    private String alias;
    private String cardNumber;
    private String expiredYM;
    private String bankCode;

    @Builder
    public CardCreate(Long userId, String alias, String cardNumber, String expiredYM, String bankCode) {
        this.userId = userId;
        this.alias = alias;
        this.cardNumber = cardNumber;
        this.expiredYM = expiredYM;
        this.bankCode = bankCode;
    }
}
