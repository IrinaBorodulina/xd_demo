package com.xdemo.demo.user.mapper;

import com.xdemo.demo.reservation.mapper.ReservationListMapper;
import com.xdemo.demo.user.dto.UserDto;
import com.xdemo.demo.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ReservationListMapper.class})
public interface UserMapper {

    User toEntity(UserDto model);

    UserDto toDto(User model);
}
