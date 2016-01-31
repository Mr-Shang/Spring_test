package com.zttc.spring.dao;

import com.zttc.spring.model.User;

import java.util.List;

/**
 * Created by �� on 2016/1/30.
 */
public interface IUserDao {
    public void add(User user,int groupid);
    public void update(User user);
    public void delete(int id);
    public User load(int id);
    public List<User> list();
}
