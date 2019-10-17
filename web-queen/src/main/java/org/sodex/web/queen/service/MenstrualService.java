package org.sodex.web.queen.service;

import org.sodex.web.common.bean.PageVo;

public interface MenstrualService {

    String glance() throws Exception;

    String tableDetail(PageVo pageVo) throws Exception;

}
