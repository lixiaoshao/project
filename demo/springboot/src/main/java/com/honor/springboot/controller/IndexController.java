package com.honor.springboot.controller;

import com.honor.springboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * com.honor.springboot.controller
 *
 * @author honor-ljp
 * 2022/12/31 20:34
 */
@Controller
@RequestMapping("/index/")
public class IndexController {
    @ResponseBody
    @RequestMapping("entity")
    public User User(User user) {
        System.out.println("user = " + user);
        return user;
    }
    @RequestMapping("model")
    public String modelTest(Model model,
                            Map<String, String> map) {
        model.addAttribute("index", "value");
        map.put("map1", "value1");
        return "forward:modelRedirect";
    }
    @ResponseBody
    @RequestMapping("modelRedirect")
    public Map modelTest(ServletRequest request) {
        Map<String, Object> maps = new HashMap<>();
        maps.put("index", request.getAttribute("index"));
        maps.put("map1", request.getAttribute("map1"));
        maps.put("a", request.getAttribute("a"));
        return maps;
    }
    @ResponseBody
    @RequestMapping("hello")
    public String index() {
        return "Hello word Spring Boot!";
    }

    /**
     * 矩阵变量测试
     * http://localhost:8086/index/product/1;name=chaoge/2;name=cx
     * 说明： developer 绑定的是1 test绑定的是2 如果URL中存在相同key（eg:name）时，pathVar定义路径名区分是哪个key
     * @param developerName
     * @param test
     * @param developerKey
     * @param testKey
     * @return
     */
    @ResponseBody
    @RequestMapping("product/{developer}/{test}")
    public Map product(@MatrixVariable(value = "name", pathVar = "developer") String developerName,
                       @MatrixVariable(value = "name", pathVar = "test") String test,
                       @PathVariable("developer") String developerKey,
                        @PathVariable("test") String testKey) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(developerKey, developerName);
        map.put(testKey, test);
        return map;
    }
}
