package service;

import entity.Order;
import org.springframework.stereotype.Service;
import repo.OrderRepo;

import java.util.List;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    public void createOrder(Order Order){
        orderRepo.save(Order);
    }

    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }

    public Order getOrderById(Long id){
        return orderRepo.findById(id).orElseThrow( () -> new RuntimeException("Order with id" + id+ " not found"));
    }

    public void updateOrder(Order Order){
        orderRepo.findById(Order.getId()).orElseThrow( () -> new RuntimeException("Order with id" + Order.getId()+ " not found"));
        orderRepo.save(Order);
    }

    public void deleteOrder(Long id){
        orderRepo.findById(id).orElseThrow( () -> new RuntimeException("Order with id" + id+ " not found"));
        orderRepo.deleteById(id);
    }

}
