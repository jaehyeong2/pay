package jjfactory.pay.biz.repository;


import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jjfactory.pay.biz.domain.DeleteStatus;
import jjfactory.pay.biz.domain.card.QCard;
import jjfactory.pay.biz.response.CardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static jjfactory.pay.biz.domain.card.QCard.*;

@RequiredArgsConstructor
@Repository
public class CardQueryRepository {
    private final JPAQueryFactory queryFactory;

    public List<CardResponse> findCardsByUsername(String username){
        return queryFactory.select(Projections.constructor(CardResponse.class, card))
                .from(card)
                .where(card.user.username.eq(username),
                        card.deleteStatus.eq(DeleteStatus.N))
                .fetch();
    }
}
