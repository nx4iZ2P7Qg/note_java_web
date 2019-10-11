package org.sodex.web.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ObjectMapper单例
 */
// todo df 不确定会不会影响性能，需要后期测试
public enum Json {

    MAPPER;

    private ObjectMapper mapper;

    Json() {
        mapper = new ObjectMapper();
    }

    public String write(Object o) throws Exception {
        return mapper.writer().writeValueAsString(o);
    }

    public Object read() {
        return mapper.reader();
    }

}
