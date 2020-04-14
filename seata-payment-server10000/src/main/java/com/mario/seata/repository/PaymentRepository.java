package com.mario.seata.repository;

import com.mario.seata.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
public interface PaymentRepository extends JpaRepository<Payment,Integer>, JpaSpecificationExecutor<Payment> {
    Payment findByUserId(Integer userId);
}
