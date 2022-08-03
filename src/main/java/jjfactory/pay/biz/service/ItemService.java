package jjfactory.pay.biz.service;


import jjfactory.pay.biz.domain.shop.Item;
import jjfactory.pay.biz.domain.shop.Shop;
import jjfactory.pay.biz.repository.ItemRepository;
import jjfactory.pay.biz.repository.ShopRepository;
import jjfactory.pay.biz.request.ItemCreate;
import jjfactory.pay.biz.request.ItemUpdate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class ItemService{
    private final ItemRepository itemRepository;
    private final ShopRepository shopRepository;

    public String create(ItemCreate dto){
        Shop shop = getShop(dto);
        Item item = Item.create(dto, shop);
        itemRepository.save(item);
        return "Y";
    }

    public String update(Long itemId,ItemUpdate dto){
        Item item = getItem(itemId);
        item.modify(dto);
        return "Y";
    }

    public String delete(Long itemId){
        Item item = getItem(itemId);
        item.delete();
        return "Y";
    }

    private Shop getShop(ItemCreate dto) {
        Shop shop = shopRepository.findById(dto.getShopId()).orElseThrow(NoSuchElementException::new);
        return shop;
    }

    private Item getItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(NoSuchElementException::new);
        return item;
    }
}
