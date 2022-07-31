package jjfactory.pay.biz.response;


import jjfactory.pay.biz.domain.pay.PayTry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PayTryInfoRes {
    private int balance;

    public PayTryInfoRes(PayTry pay) {
        this.balance = pay.getBalance();
    }
}
