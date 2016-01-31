package com.zttc.spring.test;

import com.zttc.spring.dao.RoleDao;
import com.zttc.spring.template.MyJdbcTemplateIn;
import org.junit.Test;

/**
 * Created by ¶« on 2016/1/31.
 */
public class TestTemplate {

    @Test
    public void test01(){
        MyJdbcTemplateIn myJdbcTemplateIn=new RoleDao();
        myJdbcTemplateIn.execute();
    }
    @Test
    public void test02(){
        RoleDao roleDao=new RoleDao();
        roleDao.add(1);
        roleDao.delete(1);
    }
}
