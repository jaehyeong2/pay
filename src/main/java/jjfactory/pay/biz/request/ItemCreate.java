package jjfactory.pay.biz.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ItemCreate {
    private Long shopId;
    private int price;
    private int stockQuantity;
    private String name;
}
