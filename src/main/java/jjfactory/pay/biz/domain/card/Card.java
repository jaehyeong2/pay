package jjfactory.pay.biz.domain.card;

import jjfactory.pay.biz.domain.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Comment("유저가 등록한 카드 별칭")
    private String alias;
    private String cardNumber;

    @Builder
    public Card(User user, String alias, String cardNumber) {
        this.user = user;
        this.alias = alias;
        this.cardNumber = cardNumber;
    }
}
