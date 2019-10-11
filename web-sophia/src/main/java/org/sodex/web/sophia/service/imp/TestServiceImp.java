package org.sodex.web.sophia.service.imp;

import org.sodex.web.common.repository.TestRepository;
import org.sodex.web.sophia.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestServiceImp implements TestService {

    @Resource
    TestRepository testRepository;

    @Override
    public void test(Object object) throws Exception {
        test();
    }

    private void test() throws Exception {
        
    }
}
