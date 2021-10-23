package com.lzc.user.mapper;

import com.lzc.user.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    public User getUser(User user);

}
