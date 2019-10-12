package org.sodex.web.queen.controller;

import org.sodex.web.queen.service.MenstrualService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MenstrualController {

    @Resource
    MenstrualService menstrualService;

    @GetMapping(value = "/queen/menstrual/glance")
    public String glance() throws Exception {
        // todo df 添加gateway拦截器，这样就不用每个方法都写enter into
        return menstrualService.glance();
    }

    @GetMapping(value = "/queen/menstrual/records")
    public String tableDetail(@RequestHeader Integer pageNumber,
                              @RequestHeader Integer pageSize) throws Exception {
        // 前端与后台起始index不同，前端是1，后台是0，需要转换
        return menstrualService.tableDetail(pageNumber - 1, pageSize);
    }
}
