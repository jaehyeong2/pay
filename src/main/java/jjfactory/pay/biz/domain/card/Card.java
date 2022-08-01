package jjfactory.pay.biz.domain.card;

import jjfactory.pay.biz.domain.BaseTimeEntity;
import jjfactory.pay.biz.domain.user.User;
import jjfactory.pay.biz.request.CardCreate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Card extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Comment("유저가 등록한 카드 별칭")
    private String alias;
    private String cardNumber;
    private String bankCode;
    private String expiredYM;

    @Builder
    public Card(User user, String alias, String cardNumber, String bankCode, String expiredYM) {
        this.user = user;
        this.alias = alias;
        this.cardNumber = cardNumber;
        this.bankCode = bankCode;
        this.expiredYM = expiredYM;
    }

    public static Card create(CardCreate dto, User user) {
        return Card.builder()
                .user(user)
                .alias(dto.getAlias())
                .expiredYM(dto.getExpiredYM())
                .cardNumber(dto.getCardNumber())
                .bankCode(dto.getBankCode())
                .build();
    }

    public void modifyAlias(String alias) {
        this.alias = alias;
    }
}
