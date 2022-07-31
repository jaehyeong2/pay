package jjfactory.pay.biz.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static jjfactory.pay.biz.domain.pay.QPayTry.*;

@RequiredArgsConstructor
@Repository
public class PayQueryRepository {
    private final JPAQueryFactory queryFactory;

//    public PayTryInfoRes findTotalPayAmount(){
//        return queryFactory.select(Projections.constructor(PayTryInfoRes.class,payTry))
//                .from(payTry)
//                .where(payTry.success.eq(true))
//                .fetchOne();
//    }

    public Integer findTotalPayAmountByCardId(Long cardId){
        return queryFactory.select(payTry.balance.sum())
                .from(payTry)
                .where(payTry.success.eq(true),
                        payTry.card.id.eq(cardId))
                .fetchOne();
    }

}
