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
@Table(name="t_payment")
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer Id;
    /*
    * 用户id
    * */
    @Column(name = "user_id")
    private Integer userId;
    /*
    * 总额度
    * */
    @Column(name = "total")
    private Integer total;
    /*
    * 已用余额
    * */
    @Column(name = "used")
    private Integer used;
    /*
    * 剩余额度
    * */
    @Column(name = "residue")
    private Integer residue;
}
