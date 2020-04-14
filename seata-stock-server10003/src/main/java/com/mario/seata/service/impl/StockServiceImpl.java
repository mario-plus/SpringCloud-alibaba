package com.mario.seata.service.impl;

import com.mario.seata.domain.Stock;
import com.mario.seata.repository.StockRepository;
import com.mario.seata.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;
    @Override
    public void update(Integer productId, Integer count) {
      Stock stock = stockRepository.findByProductId(productId);
      stock.setTotal(stock.getTotal()-count);
      stock.setUsed(stock.getUsed()+count);
      stock.setResidue(stock.getResidue()-count);
      stockRepository.save(stock);
    }
}
