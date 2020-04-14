package com.mario.seata.repository;

import com.mario.seata.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
public interface OrderReposity extends JpaRepository<Order,Integer>, JpaSpecificationExecutor<Order> {
    Order findByUserIdAndStatus(Integer userId,Integer status);
}
