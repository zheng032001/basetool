package com.orange.basetool.mapper.primary;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LoginLogoutMapper {

    List<Map<String,Object>> checkLogin(Map<String,Object> param);
}
