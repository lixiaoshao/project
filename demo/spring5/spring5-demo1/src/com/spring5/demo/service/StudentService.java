package com.spring5.demo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * com.spring5.demo.service
 *
 * @author lijianpeng@huice.com
 * 2022/12/26 22:40
 */
public class StudentService {
    @Override
    public String toString() {
        return "StudentService{" +
                "courses=" + Arrays.toString(courses) +
                ", list=" + list +
                ", maps=" + maps +
                ", set=" + set +
                ", userList=" + userList +
                '}';
    }

    private String[] courses;
    private List<String> list;
    private Map<String, String> maps;
    private Set<String> set;

    public void setUserList(List<UserService> userList) {
        this.userList = userList;
    }

    private List<UserService> userList;

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }
}
