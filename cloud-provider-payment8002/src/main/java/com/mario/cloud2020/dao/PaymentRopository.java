package com.mario.cloud2020.dao;

import com.mario.cloud2020.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*
 * @author：ZXZ
 * @version 2020/3/7
 */
public interface PaymentRopository extends JpaRepository<Payment, Integer>, JpaSpecificationExecutor {
}
