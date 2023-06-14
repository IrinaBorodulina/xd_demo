package com.xdemo.demo.reservation.entity;

import com.xdemo.demo.user.entity.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
@Getter
@Setter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rsv_seq")
    @SequenceGenerator(name = "rsv_seq", sequenceName = "rsv_seq", allocationSize = 1)
    @Column(name = "id")
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String info;

}

