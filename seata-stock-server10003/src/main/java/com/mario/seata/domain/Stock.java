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
@Table(name = "t_stock")
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;

    /*
    * 产品id
    * */
    @Column(name = "product_id")
    private Integer productId;

    /*
     *总库存
     * */
    @Column(name = "total")
    private Integer total;

    /*
     *已用库存
     * */
    @Column(name = "used")
    private Integer used;

    /*
     *剩余库存
     * */
    @Column(name = "residue")
    private Integer residue;
}
