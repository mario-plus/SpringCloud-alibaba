package com.mario.seata.repository;

import com.mario.seata.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
public interface StockRepository extends JpaRepository<Stock,Integer> , JpaSpecificationExecutor<Stock> {
    Stock findByProductId(Integer productId);
}
