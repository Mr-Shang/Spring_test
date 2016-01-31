package com.zttc.spring.test;

import com.zttc.spring.dao.GroupDao;
import com.zttc.spring.dao.UserDao;
import com.zttc.spring.model.Group;
import com.zttc.spring.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by �� on 2016/1/30.dd
 */
//ʹJUnite被Spring管理asdasdas
@RunWith(SpringJUnit4ClassRunner.class)
//beans.xml
@ContextConfiguration("/beans.xml")


public class TestJdbc {
    @Resource
    private UserDao userJdbcDao;
    @Resource
    private GroupDao groupJdbcDao;

    @Test
    public void add(){
        Group group=new Group();
        group.setName("abcabc");
        groupJdbcDao.add(group);
        System.out.println(group.getId());
        User user=new User("zhu","123","zhu");
        userJdbcDao.add(user,group.getId());
    }
    @Test
    public void update(){
        User user=new User("zhuhe","111","株");
        user.setId(1);
        userJdbcDao.update(user);
    }

    @Test
    public void delete(){
        userJdbcDao.delete(1);
    }
    @Test
    public void addGroup(){
        Group group=new Group();
        group.setName("abcabc");
        groupJdbcDao.add(group);
        System.out.println(group.getId());
    }

    /*

     */
    @Test
    public void load(){
        User user=userJdbcDao.load(3);
        System.out.println(user.getNickname());
        System.out.println(user.getGroup().getName());
    }
    @Test
    public void list(){
        List<User> users=userJdbcDao.list();
        for (User user:users){
            System.out.println(user);
            System.out.println("------------");
        }
    }
}
