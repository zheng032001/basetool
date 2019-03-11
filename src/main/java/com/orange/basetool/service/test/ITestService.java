package com.orange.basetool.service.test;


import java.util.List;
import java.util.Map;

public interface ITestService {

    List<Map<String,Object>> selectUserList(Map<String, Object> param);

}
