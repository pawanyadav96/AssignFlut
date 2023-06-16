package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.OrderList;

public interface OrderListRepo extends JpaRepository<OrderList, Integer>{

}
