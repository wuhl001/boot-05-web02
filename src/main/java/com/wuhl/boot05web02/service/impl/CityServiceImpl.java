package com.wuhl.boot05web02.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wuhl.boot05web02.domain.City;
import com.wuhl.boot05web02.mapper.CityMapper;
import com.wuhl.boot05web02.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ServiceImpl是IService 的实现类，两个参数分别是baseMapper和 泛型
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {
    @Autowired
    CityMapper cityMapper;




}
