package net.moulik.ecommercemoulik.service;

import net.moulik.ecommercemoulik.dao.OrderDetailsRepository;
import net.moulik.ecommercemoulik.dto.OrderDetailsDTO;
import net.moulik.ecommercemoulik.dto.OrderDetailsUpdateDTO;
import net.moulik.ecommercemoulik.entity.OrderDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderDetailsService extends BaseService{
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

    public void createOrderDetails(OrderDetailsDTO orderDetailsDTO) throws Exception {
        try {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setTotal(orderDetailsDTO.getTotal());
            orderDetails.setDetails(orderDetailsDTO.getDetails());
            orderDetails.setStatus(orderDetailsDTO.getStatus());
            // need to relate with OrderItems
            orderDetailsRepository.save(orderDetails);
        }
        catch (Exception e) {
            doHandleException(e);
        }
    }

    public void updateOrderDetails(OrderDetailsUpdateDTO orderDetailsUpdateDTO, UUID orderId) {
        Optional<OrderDetails> orderDetails = orderDetailsRepository.findById(orderId);
        if (orderDetails.isPresent()) {
            OrderDetails ods = orderDetails.get();
            ods.setId(orderDetailsUpdateDTO.getId());
            ods.setTotal(orderDetailsUpdateDTO.getTotal());
            ods.setDetails(orderDetailsUpdateDTO.getDetails());
            ods.setStatus(orderDetailsUpdateDTO.getStatus());
            orderDetailsRepository.save(ods);
        }
    }

    public void deleteOrderDetails(UUID orderId) {
        orderDetailsRepository.deleteById(orderId);
    }
}
