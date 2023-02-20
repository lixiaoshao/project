package com.honor.springboot.controller;

import com.honor.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * com.honor.springboot.controller
 *
 * @author honor-ljp
 * 2023/1/3 21:43
 */
@RequestMapping("/thymeleaf")
@Controller
public class ThymeleafController {
    @Resource
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/login.html")
    public String loginPage() {
        return "login";
    }
    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session) {
        if (StringUtils.hasText(user.getUserName()) && "123456".equals(user.getPassword())) {
            session.setAttribute("user", user);
            return "redirect:/thymeleaf/index.html";
        }
        model.addAttribute("msg", "账号密码错误！");
        return "forward:/thymeleaf/login.html";
    }
    @RequestMapping("/index.html")
    public String index(HttpSession session, Model model) {
        if (Objects.isNull(session.getAttribute("user"))) {
            model.addAttribute("msg", "请先登录！");
            return "forward:/thymeleaf/login.html";
        }
        jdbcTemplate.queryForList("select * from spring_book");
        return "index";
    }
    @RequestMapping("/success")
    public String success(Model model) {
        model.addAttribute("title", "哈喽，大家好！");
        model.addAttribute("msg", "欢迎！");
        return "success";
    }

}
