package org.example.greenshop.service;

import org.example.greenshop.dto.OrderDto;
import org.example.greenshop.model.Order;
import org.example.greenshop.model.Result;
import org.example.greenshop.repository.OrderRepo;
import org.example.greenshop.repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    PaymentRepo paymentRepo;

    public List<Order> getAllO() {
        return orderRepo.findAll();
    }
    public Order getByIdO(Integer id) {
        return orderRepo.findById(id).get();
    }
    public Result addO(OrderDto orderDto){
        Order order = new Order();
        order.setOrder_number(orderDto.getOrder_number());
        order.setDate(orderDto.getDate());
        order.setTotal(orderDto.getTotal());
        order.setPayment_method(orderDto.getPayment_method());
        orderRepo.save(order);
        return new Result(true , "Order add");
    }
    public Result updateO(OrderDto orderDto , Integer id){
        Optional<Order> optionalOrder = orderRepo.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setOrder_number(orderDto.getOrder_number());
            order.setDate(orderDto.getDate());
            order.setTotal(orderDto.getTotal());
            order.setPayment_method(orderDto.getPayment_method());
            orderRepo.save(order);
            return new Result(true , "Order update");
        }
        return new Result(false, "Order not found");
    }
    public Result deleteO(Integer id) {
        orderRepo.deleteById(id);
        return new Result(true , "Order deleted");
    }
}
