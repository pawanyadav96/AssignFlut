package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductException;
import com.example.demo.exception.salesOrderException;
import com.example.demo.model.OrderList;
import com.example.demo.model.Product;
import com.example.demo.model.salesOrder;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.salesRepo;

@Service
public class salesServiceImpl implements salesService{

	
	@Autowired
	private salesRepo srepo;
	
	
	
	
	@Autowired 
	private ProductRepo prepo;
	@Override
	public salesOrder addSalesOrder(salesOrder salesOrder) throws ProductException, salesOrderException {
		List<OrderList> orderItems = salesOrder.getOrderItems();
		for (OrderList order : orderItems) {
	            Product product = order.getProduct();
                int QuantityNow = product.getStockquantity()-order.getSales_quantity();
	            if (QuantityNow < 0) {
	                throw new ProductException("No product available");
	            }

	            product.setStockquantity(QuantityNow);
	            prepo.save(product);
	        }
	        return srepo.save(salesOrder);
	}
	@Override
	public List<salesOrder> allSaleOrder() throws salesOrderException {
		List<salesOrder> Sales =srepo.findAll();
		return Sales;
	}
}
