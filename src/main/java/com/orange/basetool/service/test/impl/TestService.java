package com.orange.basetool.service.test.impl;

import com.orange.basetool.mapper.test.TestMapper;
import com.orange.basetool.service.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TestService implements ITestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Map<String, Object>> selectUserList(Map<String, Object> param) {
        return testMapper.getTest(param);
    }
}
