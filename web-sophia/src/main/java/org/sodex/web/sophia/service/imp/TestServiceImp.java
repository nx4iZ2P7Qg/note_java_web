package org.sodex.web.sophia.service.imp;

import org.sodex.web.common.bean.Menstrual;
import org.sodex.web.common.repository.MenstrualRepository;
import org.sodex.web.sophia.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TestServiceImp implements TestService {

    @Resource
    MenstrualRepository menstrualRepository;

    @Override
    public void test(Object object) {
        test();
    }

    public void test() {
        Menstrual menstrual = new Menstrual();
        menstrual.setCreateBy(1000L);
        menstrual.setCreateAt(LocalDateTime.now());
        menstrual.setDt(LocalDate.now());
        menstrualRepository.save(menstrual);

        System.out.println(menstrualRepository.findAll());
    }
}
