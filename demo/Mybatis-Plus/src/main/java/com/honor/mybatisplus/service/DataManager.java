package com.honor.mybatisplus.service;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * com.honor.mybatisplus.service
 *
 * @author honor-ljp
 * 2023/2/8 9:14
 */
public class DataManager {
    protected Map<String, String> datasources = Collections
            .synchronizedMap(new HashMap<String, String>());

    protected String getDataSources() {
        String key = "index";
        if (!datasources.containsKey(key)) {
            datasources.put(key, "是这个值");
        }
        return datasources.get(key);
    }


    public static void main(String[] args) {
        DataManager dataManager = new DataManager();
        String dataSources = dataManager.getDataSources();
        String dataSources1 = dataManager.getDataSources();

        DataManager dataManager1 = new DataManager();
        System.out.println(dataManager1.getDataSources());
        System.out.println(dataSources1);
    }

}
