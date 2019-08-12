package com.yuanziren.mapper;


import com.yuanziren.dto.UserDto;

import java.util.List;

public interface UserMapper {


    public List<UserDto> queryUserCard();
    public List<UserDto> queryUserCardAccount();
    public Integer updateUser(Integer id);

}
