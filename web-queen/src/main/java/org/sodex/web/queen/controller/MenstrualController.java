package org.sodex.web.queen.controller;

import org.sodex.web.common.bean.PageVo;
import org.sodex.web.queen.service.MenstrualService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MenstrualController {

    @Resource
    MenstrualService menstrualService;

    @GetMapping(value = "/menstrual/glance", headers = "X-API-VERSION=1")
    public String glance() throws Exception {
        // todo df 添加gateway拦截器，这样就不用每个方法都写enter into
        return menstrualService.glance();
    }

    @GetMapping(value = "/menstruals", headers = "X-API-VERSION=1")
    public String getMenstruals(PageVo pageVo) throws Exception {
        return menstrualService.getMenstruals(pageVo);
    }

}
