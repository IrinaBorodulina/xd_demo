package com.xdemo.demo.user.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.xdemo.demo.reservation.entity.Reservation;
import com.xdemo.demo.utils.Views;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usr_seq")
    @SequenceGenerator(name = "usr_seq", sequenceName = "usr_seq", allocationSize = 1)
    @Column(name = "id")
    @JsonView({Views.Response.class, Views.Request.class})
    private Integer id;

    @Column(name = "birth_year")
    @JsonView({Views.Response.class, Views.Request.class})
    private Integer birthYear;

    @JsonView(Views.Response.class)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

}

