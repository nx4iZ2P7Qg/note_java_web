package org.sodex.web.sophia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Menstrul {
    
    @GetMapping(value="/test")
    public String getTest() {
        return "hello webflex";
    }
    
    @PostMapping(value="/login")
    public String login() throws Exception{
        System.out.println("login");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();
        data.put("token", "super_admin");
        return mapper.writeValueAsString(data);
    }
    
    @GetMapping(value="/get_info")
    public String getUserInfo(@RequestParam String token) throws Exception {
        System.out.println("getUserInfo");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();
        data.put("avatar", "https://file.iviewui.com/dist/a0e88e83800f138b94d2414621bd9704.png");
        data.put("name", "super_admin");
        data.put("user_id", "1");
        String[] accessArr = {"super_admin", "admin"};
        data.put("access", accessArr);
        return mapper.writeValueAsString(data);
    }
    
    @GetMapping(value="/message/count")
    public int getMessageCount() {
        System.out.println("getMessageCount");
        return 96;
    }
}
