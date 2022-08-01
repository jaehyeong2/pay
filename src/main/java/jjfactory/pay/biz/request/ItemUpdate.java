package jjfactory.pay.biz.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ItemUpdate {
    private int price;
    private int stockQuantity;
    private String name;
}
