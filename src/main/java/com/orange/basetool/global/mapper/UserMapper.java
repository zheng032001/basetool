package com.orange.basetool.global.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    List<Map<String,Object>> checkLogin(Map<String,Object> param);


    List<Map<String,Object>> getUserList(Map<String,Object> param);
}
