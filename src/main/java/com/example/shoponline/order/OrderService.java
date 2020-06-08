package com.example.shoponline.order;

import com.example.shoponline.order.OrderConverter;
import com.example.shoponline.order.OrderEntity;
import com.example.shoponline.order.OrderDto;
import com.example.shoponline.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderService {

    private OrderRepository orderRepository;
    private OrderConverter orderConverter;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderConverter orderConverter) {
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
    }

    public List<OrderDto> getAll() {
        List<OrderEntity> orderEntities = this.orderRepository.findAll();
        return this.orderConverter.toDtos(orderEntities);
    }

    public OrderDto getOne(Integer id) {
        OrderEntity orderEntity = this.orderRepository.findById(id).orElse(null);
        return this.orderConverter.getOne(orderEntity);
    }

    public OrderDto save(OrderDto orderDto, Integer id) {
        OrderEntity savedOrderEntity;
        if (id == null) {
            savedOrderEntity = this.orderRepository.save(this.orderConverter.toEntity(orderDto, null));
        } else {
            savedOrderEntity = this.orderRepository.save(this.orderConverter.toEntity(orderDto, this.orderRepository.getOne(id)));
        }
        return this.orderConverter.toDto(savedOrderEntity);

    }
}
