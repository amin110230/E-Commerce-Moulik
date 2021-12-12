package net.moulik.ecommercemoulik.service;

import net.moulik.ecommercemoulik.dao.OrderDetailsRepository;
import net.moulik.ecommercemoulik.dto.OrderDetailsDTO;
import net.moulik.ecommercemoulik.entity.OrderDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public List<OrderDetailsDTO> getOrders() {
        List<OrderDetails> orderDetailsList = orderDetailsRepository.findAll();
        return getOrderDetailsDTOS(orderDetailsList);
    }

    public OrderDetailsDTO getOrderById(UUID orderId) {
        Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(orderId);
        if (orderDetails.isPresent()) {
            OrderDetails odrDtls = orderDetails.get();
            OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
            orderDetailsDTO.setTotal(odrDtls.getTotal());
            orderDetailsDTO.setDetails(odrDtls.getDetails());
            orderDetailsDTO.setStatus(odrDtls.getStatus());
            return orderDetailsDTO;
        }
        return null;
    }

    public List<OrderDetailsDTO> getOrderByStatus(String orderStatus) {
        List<OrderDetails> orderDetailsList = orderDetailsRepository.getOrderDetailsByStatus(orderStatus);
        return getOrderDetailsDTOS(orderDetailsList);
    }

    private List<OrderDetailsDTO> getOrderDetailsDTOS(List<OrderDetails> orderDetailsList) {
        List<OrderDetailsDTO> orderDetailsDTOList = new ArrayList<>();
        for (OrderDetails orderDetails : orderDetailsList) {
            OrderDetailsDTO orderDetailsDTO = new OrderDetailsDTO();
            orderDetailsDTO.setTotal(orderDetails.getTotal());
            orderDetailsDTO.setDetails(orderDetails.getDetails());
            orderDetailsDTO.setStatus(orderDetails.getStatus());
            orderDetailsDTOList.add(orderDetailsDTO);
        }
        return orderDetailsDTOList;
    }
}
