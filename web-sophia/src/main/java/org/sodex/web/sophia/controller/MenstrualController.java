package org.sodex.web.sophia.controller;

import org.sodex.web.sophia.service.MenstrualService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MenstrualController {

    @Resource
    MenstrualService menstrualService;

    @GetMapping(value = "/sophia/menstrual/glance")
    public String glance() throws Exception {
        // todo df 添加gateway拦截器，这样就不用每个方法都写enter into
        return menstrualService.glance();
    }
}
