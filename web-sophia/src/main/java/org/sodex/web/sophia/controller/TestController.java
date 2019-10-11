package org.sodex.web.sophia.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.sodex.web.common.bean.vo.MessageIdVo;
import org.sodex.web.sophia.service.TestService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Resource
    TestService testService;

    @PostMapping(value = "/user/login")
    public String login() throws Exception {
        System.out.println("login");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();
        data.put("token", "super_admin");
        return mapper.writeValueAsString(data);
    }

    @GetMapping(value = "/user/get_info")
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

    @PostMapping(value = "/user/logout")
    public String logout() {
        return null;
    }

    @GetMapping(value = "/user/message/count")
    public int getMessageCount() {
        System.out.println("getMessageCount");
        return 96;
    }

    @GetMapping(value = "/user/message/init")
    public String messageInit() throws Exception {
        System.out.println("message init");
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List> reMap = new HashMap<>();
        List<Map> unreadList = new ArrayList<>();
        Map<String, Object> unread = new HashMap<>();
        unread.put("title", "今天是中秋前最后一天");
        unread.put("create_time", "2019-09-12");
        unread.put("msg_id", 61);
        unreadList.add(unread);
        reMap.put("unread", unreadList);

        List<Map> readList = new ArrayList<>();
        Map<String, Object> read = new HashMap<>();
        read.put("title", "已读消息");
        read.put("create_time", LocalDate.now() + "");
        read.put("msg_id", 71);
        readList.add(read);
        reMap.put("read", readList);
        Map<String, Object> read2 = new HashMap<>();
        read2.put("title", "上个月扣税高多");
        read2.put("create_time", "2018-07-01");
        read2.put("msg_id", 72);
        readList.add(read2);

        List<Map> trashList = new ArrayList<>();
        Map<String, Object> trash = new HashMap<>();
        trash.put("title", "辣鸡消息");
        trash.put("create_time", LocalDate.now() + "");
        trash.put("msg_id", 81);
        trashList.add(trash);
        reMap.put("trash", trashList);
        return mapper.writeValueAsString(reMap);
    }

    @GetMapping(value = "/user/message/content")
    public String messageContent(@RequestParam("msg_id") Long msgId) throws Exception {
        System.out.println("messageContent-msgId = " + msgId);
        return "消息内容";
    }

    @PostMapping(value = "/user/message/has_read")
    public boolean messageHasRead(@RequestBody MessageIdVo vo) throws Exception {
        System.out.println(vo.getMsgId());
        System.out.println("messageHasRead-vo = " + new ObjectMapper().writeValueAsString(vo));
        return true;
    }

    @PostMapping(value = "/user/message/remove_read")
    public boolean messageRemoveRead(@RequestBody MessageIdVo vo) throws Exception {
        System.out.println("messageRemoveRead-vo = " + new ObjectMapper().writeValueAsString(vo));
        return true;
    }

    @PostMapping(value = "/user/message/restore")
    public boolean messageRestore(@RequestBody MessageIdVo vo) throws Exception {
        System.out.println("messageRestore-vo = " + new ObjectMapper().writeValueAsString(vo));
        return true;
    }

    @PostMapping(value = "/test/test")
    public void test(@RequestBody Object object) throws Exception {
        System.out.println("enter into test");
        testService.test(object);
    }
}
