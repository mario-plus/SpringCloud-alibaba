package com.mario.seata.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
 * @author：ZXZ
 * @version 2020/3/14
 */
@Data
@Entity
@Table(name = "t_order")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    /*
    * 用户id
    * */
    @Column(name="user_id")
    private Integer userId;

    /*
    * 产品id
    * */
    @Column(name="product_id")
    private Integer productId;

    /*
    * 数量
    * */
    @Column(name="count")
    private Integer count;

    /*
    * 金额
    * */
    @Column(name="money")
    private Integer money;

    /*
    * 订单状态，0：创建中  1：已完结
    * */
    @Column(name="status")
    private Integer status;
}
