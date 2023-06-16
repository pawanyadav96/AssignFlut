package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ProductException;
import com.example.demo.exception.salesOrderException;
import com.example.demo.model.OrderList;
import com.example.demo.model.Product;
import com.example.demo.model.salesOrder;
import com.example.demo.repository.OrderListRepo;
import com.example.demo.repository.ProductRepo;
import com.example.demo.repository.salesRepo;

@Service
public class salesServiceImpl implements salesService{

	
	  @Autowired
	  private salesRepo srepo;
	  
	  @Autowired
	  private OrderListRepo orrepo;
	  
	
	  @Autowired 
	  private ProductRepo prepo;
	  
	  @Autowired
	  private ProductService pService;
	
	@Override
	public salesOrder addSalesOrder(salesOrder salesOrder) throws ProductException, salesOrderException {
	
		Optional<salesOrder> opt = srepo.findById(salesOrder.getId());
		if(opt.isPresent()) {
			throw new salesOrderException("sales order exist");
		}
		salesOrder.setTimestamp(LocalDateTime.now());
		for(OrderList ord : salesOrder.getOrderItems()) {
			
			Product product = pService.findById(ord.getProduct().getId());
			
			product.setStockquantity(product.getStockquantity()-ord.getSales_quantity());
			pService.createProduct(product);
			ord.setSOrder(salesOrder);
		}
		
		return srepo.save(salesOrder);
		
	}
	
	@Override
	public List<salesOrder> allSaleOrder() throws salesOrderException {
		List<salesOrder> Sales =srepo.findAll();
		return Sales;
	}

}
