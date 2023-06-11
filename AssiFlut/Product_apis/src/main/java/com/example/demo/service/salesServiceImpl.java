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
	            Optional<Product> product = prepo.findById(order.getProduct().getId());
	            
	            Product pp=product.get();
               // int QuantityNow = pp.getStockquantity()-order.getSales_quantity();
	            if (pp.getStockquantity() < order.getSales_quantity()) {
	                throw new ProductException("No product available");
	            }

	            pp.setStockquantity(pp.getStockquantity() - order.getSales_quantity());
	            prepo.save(pp);
	        }
	        return srepo.save(salesOrder);
	}
	@Override
	public List<salesOrder> allSaleOrder() throws salesOrderException {
		List<salesOrder> Sales =srepo.findAll();
		return Sales;
	}
}
