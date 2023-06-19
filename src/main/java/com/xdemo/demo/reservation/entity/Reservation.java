package com.xdemo.demo.reservation.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.xdemo.demo.user.entity.User;
import com.xdemo.demo.utils.Views;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@JsonView
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rsv_seq")
    @SequenceGenerator(name = "rsv_seq", sequenceName = "rsv_seq", allocationSize = 1)
    @Column(name = "id")
    @JsonView(Views.Response.class)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonView(Views.Request.class)
    private User user;
    @Column
    @JsonView({Views.Response.class, Views.Request.class})
    @JsonProperty("resInfo")
    private String info;

}

