package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.ProductException;
import com.example.demo.exception.salesOrderException;
import com.example.demo.model.OrderList;
import com.example.demo.model.Product;
import com.example.demo.model.salesOrder;

public interface salesService {
//	public  OrderList addProductToOrderList(Product product) throws ProductException;
	
     public salesOrder addSalesOrder(salesOrder salesOrder) throws ProductException ,salesOrderException;
	 
	 public List<salesOrder> allSaleOrder() throws salesOrderException;
}
