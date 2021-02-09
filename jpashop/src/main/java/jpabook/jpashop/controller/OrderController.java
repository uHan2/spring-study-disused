package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderSearch;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import jpabook.jpashop.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController
{
    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model)
    {
        List<Member> members = memberService.findMembers();
        List<Item> items = itemService.findItems();

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return"order/orderForm";
    }

    /**
     * @RequestParam 으로 요청값을 변수에 바인딩해도 되고, OrderRequestDto 같은 Command Object를 통해 바인딩 해도 된다.
     */
    @PostMapping("/order")
    public String order(OrderRequestDto orderRequestDto)
//    public String order(@RequestParam("memberId") Long memberId,
//                        @RequestParam("itemId") Long itemId,
//                        @RequestParam("count") int count)
    {
//        orderService.order(memberId, itemId, count);
//        orderService.order(orderRequestDto); // 이렇게 command object 를 넘겨도 되고 (대신 구현해야함)
        orderService.order(orderRequestDto.getMemberId(), orderRequestDto.getItemId(), orderRequestDto.getCount());

        return "redirect:/orders";
    }

    @Data
    @AllArgsConstructor
    static class OrderRequestDto
    {
        private Long memberId;
        private Long itemId;
        private int count;
    }

    @GetMapping("/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model)
    {
        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders", orders);

        return "order/orderList";
    }

    @PostMapping("/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId)
    {
        orderService.cancelOrder(orderId);

        return "redirect:/orders";
    }
}
