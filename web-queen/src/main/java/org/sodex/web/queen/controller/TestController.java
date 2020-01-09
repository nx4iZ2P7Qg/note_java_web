package org.sodex.web.queen.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.sodex.web.common.bean.vo.MessageIdVo;
import org.sodex.web.queen.service.TestService;
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

    // ---------------------------- iview start ----------------------------

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

    // ---------------------------- iview end ----------------------------
    
    @PostMapping(value = "/test/test")
    public void test(@RequestBody Object object) throws Exception {
        System.out.println("enter into test");
        testService.test(object);
    }
    
    // ---------------------------- ant design pro start ----------------------------
    @PostMapping(value = "/auth/login")
    public String antLogin() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> reMap = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("token", "4291d7da9005377ec9aec4a71ea837f");
        reMap.put("result", resultMap);
        reMap.put("message", "message");
        reMap.put("code", 200);
        reMap.put("_status", 200);
        return mapper.writeValueAsString(reMap);
    }
    
    @PostMapping(value = "/auth/2step-code")
    public String twoStepCode() {
        return "bbb";
    }
    
    @PostMapping(value = "/auth/logout")
    public String antLogout() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> reMap = new HashMap<>();
        Map<String, Object> resultMap = new HashMap<>();
        reMap.put("result", resultMap);
        reMap.put("message", "message");
        reMap.put("code", 200);
        reMap.put("_status", 200);
        return mapper.writeValueAsString(reMap);
    }
    
    @GetMapping(value = "/user/info")
    public String userInfo() {
        JSONObject reJson = new JSONObject();
        String userInfo = "{    \"id\": \"4291d7da9005377ec9aec4a71ea837f\",    \"name\": \"天野远子\",    \"username\": \"admin\",    \"password\": \"\",    \"avatar\": \"/avatar2.jpg\",    \"status\": 1,    \"telephone\": \"\",    \"lastLoginIp\": \"27.154.74.117\",    \"lastLoginTime\": 1534837621348,    \"creatorId\": \"admin\",    \"createTime\": 1497160610259,    \"merchantCode\": \"TLif2btpzg079h15bk\",    \"deleted\": 0,    \"roleId\": \"admin\",    \"role\": {}  }";
        String roleObj = "{    \"id\": \"admin\",    \"name\": \"管理员\",    \"describe\": \"拥有所有权限\",    \"status\": 1,    \"creatorId\": \"system\",    \"createTime\": 1497160610259,    \"deleted\": 0,    \"permissions\": [{      \"roleId\": \"admin\",      \"permissionId\": \"dashboard\",      \"permissionName\": \"仪表盘\",      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],      \"actionEntitySet\": [{        \"action\": \"add\",        \"describe\": \"新增\",        \"defaultCheck\": false      }, {        \"action\": \"query\",        \"describe\": \"查询\",        \"defaultCheck\": false      }, {        \"action\": \"get\",        \"describe\": \"详情\",        \"defaultCheck\": false      }, {        \"action\": \"update\",        \"describe\": \"修改\",        \"defaultCheck\": false      }, {        \"action\": \"delete\",        \"describe\": \"删除\",        \"defaultCheck\": false      }],      \"actionList\": null,      \"dataAccess\": null    }, {      \"roleId\": \"admin\",      \"permissionId\": \"exception\",      \"permissionName\": \"异常页面权限\",      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],      \"actionEntitySet\": [{        \"action\": \"add\",        \"describe\": \"新增\",        \"defaultCheck\": false      }, {        \"action\": \"query\",        \"describe\": \"查询\",        \"defaultCheck\": false      }, {        \"action\": \"get\",        \"describe\": \"详情\",        \"defaultCheck\": false      }, {        \"action\": \"update\",        \"describe\": \"修改\",        \"defaultCheck\": false      }, {        \"action\": \"delete\",        \"describe\": \"删除\",        \"defaultCheck\": false      }],      \"actionList\": null,      \"dataAccess\": null    }, {      \"roleId\": \"admin\",      \"permissionId\": \"result\",      \"permissionName\": \"结果权限\",      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],      \"actionEntitySet\": [{        \"action\": \"add\",        \"describe\": \"新增\",        \"defaultCheck\": false      }, {        \"action\": \"query\",        \"describe\": \"查询\",        \"defaultCheck\": false      }, {        \"action\": \"get\",        \"describe\": \"详情\",        \"defaultCheck\": false      }, {        \"action\": \"update\",        \"describe\": \"修改\",        \"defaultCheck\": false      }, {        \"action\": \"delete\",        \"describe\": \"删除\",        \"defaultCheck\": false      }],      \"actionList\": null,      \"dataAccess\": null    }, {      \"roleId\": \"admin\",      \"permissionId\": \"profile\",      \"permissionName\": \"详细页权限\",      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],      \"actionEntitySet\": [{        \"action\": \"add\",        \"describe\": \"新增\",        \"defaultCheck\": false      }, {        \"action\": \"query\",        \"describe\": \"查询\",        \"defaultCheck\": false      }, {        \"action\": \"get\",        \"describe\": \"详情\",        \"defaultCheck\": false      }, {        \"action\": \"update\",        \"describe\": \"修改\",        \"defaultCheck\": false      }, {        \"action\": \"delete\",        \"describe\": \"删除\",        \"defaultCheck\": false      }],      \"actionList\": null,      \"dataAccess\": null    }, {      \"roleId\": \"admin\",      \"permissionId\": \"table\",      \"permissionName\": \"表格权限\",      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"import\",\"defaultCheck\":false,\"describe\":\"导入\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"}],      \"actionEntitySet\": [{        \"action\": \"add\",        \"describe\": \"新增\",        \"defaultCheck\": false      }, {        \"action\": \"import\",        \"describe\": \"导入\",        \"defaultCheck\": false      }, {        \"action\": \"get\",        \"describe\": \"详情\",        \"defaultCheck\": false      }, {        \"action\": \"update\",        \"describe\": \"修改\",        \"defaultCheck\": false      }],      \"actionList\": null,      \"dataAccess\": null    }, {      \"roleId\": \"admin\",      \"permissionId\": \"form\",      \"permissionName\": \"表单权限\",      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],      \"actionEntitySet\": [{        \"action\": \"add\",        \"describe\": \"新增\",        \"defaultCheck\": false      }, {        \"action\": \"get\",        \"describe\": \"详情\",        \"defaultCheck\": false      }, {        \"action\": \"query\",        \"describe\": \"查询\",        \"defaultCheck\": false      }, {        \"action\": \"update\",        \"describe\": \"修改\",        \"defaultCheck\": false      }, {        \"action\": \"delete\",        \"describe\": \"删除\",        \"defaultCheck\": false      }],      \"actionList\": null,      \"dataAccess\": null    }, {      \"roleId\": \"admin\",      \"permissionId\": \"order\",      \"permissionName\": \"订单管理\",      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],      \"actionEntitySet\": [{        \"action\": \"add\",        \"describe\": \"新增\",        \"defaultCheck\": false      }, {        \"action\": \"query\",        \"describe\": \"查询\",        \"defaultCheck\": false      }, {        \"action\": \"get\",        \"describe\": \"详情\",        \"defaultCheck\": false      }, {        \"action\": \"update\",        \"describe\": \"修改\",        \"defaultCheck\": false      }, {        \"action\": \"delete\",        \"describe\": \"删除\",        \"defaultCheck\": false      }],      \"actionList\": null,      \"dataAccess\": null    }, {      \"roleId\": \"admin\",      \"permissionId\": \"permission\",      \"permissionName\": \"权限管理\",      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],      \"actionEntitySet\": [{        \"action\": \"add\",        \"describe\": \"新增\",        \"defaultCheck\": false      }, {        \"action\": \"get\",        \"describe\": \"详情\",        \"defaultCheck\": false      }, {        \"action\": \"update\",        \"describe\": \"修改\",        \"defaultCheck\": false      }, {        \"action\": \"delete\",        \"describe\": \"删除\",        \"defaultCheck\": false      }],      \"actionList\": null,      \"dataAccess\": null    }, {      \"roleId\": \"admin\",      \"permissionId\": \"role\",      \"permissionName\": \"角色管理\",      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],      \"actionEntitySet\": [{        \"action\": \"add\",        \"describe\": \"新增\",        \"defaultCheck\": false      }, {        \"action\": \"get\",        \"describe\": \"详情\",        \"defaultCheck\": false      }, {        \"action\": \"update\",        \"describe\": \"修改\",        \"defaultCheck\": false      }, {        \"action\": \"delete\",        \"describe\": \"删除\",        \"defaultCheck\": false      }],      \"actionList\": null,      \"dataAccess\": null    }, {      \"roleId\": \"admin\",      \"permissionId\": \"table\",      \"permissionName\": \"桌子管理\",      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],      \"actionEntitySet\": [{        \"action\": \"add\",        \"describe\": \"新增\",        \"defaultCheck\": false      }, {        \"action\": \"get\",        \"describe\": \"详情\",        \"defaultCheck\": false      }, {        \"action\": \"query\",        \"describe\": \"查询\",        \"defaultCheck\": false      }, {        \"action\": \"update\",        \"describe\": \"修改\",        \"defaultCheck\": false      }, {        \"action\": \"delete\",        \"describe\": \"删除\",        \"defaultCheck\": false      }],      \"actionList\": null,      \"dataAccess\": null    }, {      \"roleId\": \"admin\",      \"permissionId\": \"user\",      \"permissionName\": \"用户管理\",      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"import\",\"defaultCheck\":false,\"describe\":\"导入\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"},{\"action\":\"export\",\"defaultCheck\":false,\"describe\":\"导出\"}],      \"actionEntitySet\": [{        \"action\": \"add\",        \"describe\": \"新增\",        \"defaultCheck\": false      }, {        \"action\": \"import\",        \"describe\": \"导入\",        \"defaultCheck\": false      }, {        \"action\": \"get\",        \"describe\": \"详情\",        \"defaultCheck\": false      }, {        \"action\": \"update\",        \"describe\": \"修改\",        \"defaultCheck\": false      }, {        \"action\": \"delete\",        \"describe\": \"删除\",        \"defaultCheck\": false      }, {        \"action\": \"export\",        \"describe\": \"导出\",        \"defaultCheck\": false      }],      \"actionList\": null,      \"dataAccess\": null    }]  }";
        String permissions = "{    \"roleId\": \"admin\",    \"permissionId\": \"support\",    \"permissionName\": \"超级模块\",    \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"import\",\"defaultCheck\":false,\"describe\":\"导入\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"},{\"action\":\"export\",\"defaultCheck\":false,\"describe\":\"导出\"}],    \"actionEntitySet\": [{      \"action\": \"add\",      \"describe\": \"新增\",      \"defaultCheck\": false    }, {      \"action\": \"import\",      \"describe\": \"导入\",      \"defaultCheck\": false    }, {      \"action\": \"get\",      \"describe\": \"详情\",      \"defaultCheck\": false    }, {      \"action\": \"update\",      \"describe\": \"修改\",      \"defaultCheck\": false    }, {      \"action\": \"delete\",      \"describe\": \"删除\",      \"defaultCheck\": false    }, {      \"action\": \"export\",      \"describe\": \"导出\",      \"defaultCheck\": false    }],    \"actionList\": null,    \"dataAccess\": null  }";
        JSONObject user = JSONObject.fromObject(userInfo);
        JSONObject role = JSONObject.fromObject(roleObj);
        JSONObject permission = JSONObject.fromObject(permissions);
        JSONArray permissionsArray = role.getJSONArray("permissions");
        permissionsArray.add(permission);
        role.put("permissions", permissionsArray);
        user.put("role", role);
        

//                'lastLoginIp': '27.154.74.117',
//                'lastLoginTime': 1534837621348,
//                'creatorId': 'admin',
//                'createTime': 1497160610259,
//                'merchantCode': 'TLif2btpzg079h15bk',
//                'deleted': 0,
//                'roleId': 'admin',
//                'role': {}
        reJson.put("result", user);
        reJson.put("message", "");
        reJson.put("code", 200);
        return reJson.toString();
    }
    // ---------------------------- ant design pro end ----------------------------
}
