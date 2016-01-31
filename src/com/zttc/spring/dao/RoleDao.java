package com.zttc.spring.dao;

import com.zttc.spring.template.MyJdbcTemplate;
import com.zttc.spring.template.MyJdbcTemplateIn;

/**
 * Created by ¶« on 2016/1/31.
 */
public class RoleDao extends MyJdbcTemplateIn {
    MyJdbcTemplate myJdbcTemplate=new MyJdbcTemplate();

    public void add(int id){
        myJdbcTemplate.add(id);
    }
    public void delete(int id){
        myJdbcTemplate.delete(id);
    }
    @Override
    public void run() {
        System.out.println("Role is Running");
    }

    @Override
    public boolean isLog() {

        return false;
    }
}
