package jjfactory.pay.biz.domain.shop;

import jjfactory.pay.biz.domain.BaseTimeEntity;
import jjfactory.pay.biz.request.ItemCreate;
import jjfactory.pay.biz.request.ItemUpdate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Item extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "shop_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Shop shop;

    private int price;
    private int stockQuantity;
    private String name;

    @Builder
    public Item(Shop shop, int price, int stockQuantity, String name) {
        this.shop = shop;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.name = name;
    }

    public static Item create(ItemCreate dto, Shop shop){
        return Item.builder()
                .shop(shop)
                .name(dto.getName())
                .price(dto.getPrice())
                .stockQuantity(dto.getStockQuantity())
                .build();
    }

    public void modify(ItemUpdate dto) {
        this.price = dto.getPrice();
        this.stockQuantity = dto.getStockQuantity();
        this.name = dto.getName();
    }
}
