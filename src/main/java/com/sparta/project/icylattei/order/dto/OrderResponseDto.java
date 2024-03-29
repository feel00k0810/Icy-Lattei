package com.sparta.project.icylattei.order.dto;

import com.sparta.project.icylattei.cart.dto.CartResponseDto;
import com.sparta.project.icylattei.cart.entity.Cart;
import com.sparta.project.icylattei.order.entity.Order;
import com.sparta.project.icylattei.product.entity.Product;
import java.sql.Date;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderResponseDto {

    private Long id; //주문번호
    private List<CartResponseDto> carts;
    private int totalPrice = 0;
    private Date orderDate;


    public OrderResponseDto(Order order, List<CartResponseDto> carts) {
        this.carts = carts;
        this.id = order.getOrderId();
        this.orderDate = order.getOrderDate();
        for (CartResponseDto cart : carts) {
            totalPrice += cart.getQuantity() * cart.getProduct().getPrice();
        }
    }
}
