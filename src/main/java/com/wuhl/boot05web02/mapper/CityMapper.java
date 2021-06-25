package com.wuhl.boot05web02.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wuhl.boot05web02.domain.City;
import org.apache.ibatis.annotations.Mapper;

/**
 * 我们的mapper只要继承BaseMapper就可以有CRUD功能
 * 不需要自己写
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {
}
