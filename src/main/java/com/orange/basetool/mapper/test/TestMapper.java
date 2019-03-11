package com.orange.basetool.mapper.test;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TestMapper {

    List<Map<String,Object>> getTest(Map<String, Object> param);
}
