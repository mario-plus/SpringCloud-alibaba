package com.mario.cloud2020.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/*
 * @author：ZXZ
 * @version 2020/3/7
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "payment")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "serial")
    private String serial;
}
