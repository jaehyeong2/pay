package jjfactory.pay.biz.service;

import jjfactory.pay.biz.domain.card.Card;
import jjfactory.pay.biz.domain.shop.Item;
import jjfactory.pay.biz.domain.shop.Order;
import jjfactory.pay.biz.domain.shop.Shop;
import jjfactory.pay.biz.domain.user.User;
import jjfactory.pay.biz.repository.*;
import jjfactory.pay.biz.request.ItemCreate;
import jjfactory.pay.biz.request.ItemUpdate;
import jjfactory.pay.biz.request.OrderCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Transactional
@Service
public class OrderService {
    private final ItemRepository itemRepository;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final ShopRepository shopRepository;
    private final UserRepository userRepository;
    private final CardRepository cardRepository;

    public String create(OrderCreate dto){
        Card card = getCard(dto.getCardId());
        Order order = Order.create(card);
        orderRepository.save(order);
        return "Y";
    }

    public String update(Long itemId, ItemUpdate dto){
        Item item = getItem(itemId);
        item.modify(dto);
        return "Y";
    }

    public String delete(Long orderId){
        Order order = getOrder(orderId);
        order.delete();
        return "Y";
    }


    private Order getOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(NoSuchElementException::new);
        return order;
    }

    private Card getCard(Long cardId) {
        Card card = cardRepository.findById(cardId).orElseThrow(NoSuchElementException::new);
        return card;
    }

    private User getUser(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(NoSuchElementException::new);
        return user;
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
