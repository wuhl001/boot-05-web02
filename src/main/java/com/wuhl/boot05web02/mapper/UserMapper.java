package com.wuhl.boot05web02.mapper;

import com.wuhl.boot05web02.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface UserMapper {

    @Select("select * from user")
    List<User> findAllUser();
}
