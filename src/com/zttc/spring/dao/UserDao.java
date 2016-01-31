package com.zttc.spring.dao;

import com.zttc.spring.model.Group;
import com.zttc.spring.model.User;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dong on 2016/1/30.
 */
@Repository("userJdbcDao")
public class UserDao implements IUserDao {
    private JdbcTemplate jdbcTemplate;


    @Resource
    public void setDataSource(BasicDataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate( dataSource);
//        jdbcTemplate=new JdbcTemplate(dataSource);
    }

    @Override
    public void add(User user,int groupid) {
        jdbcTemplate.update("INSERT into t_user (user_name,pass_word,nick_name,groupid) VALUES (?,?,?,?)",
                user.getUsername(),user.getPassword(),user.getNickname(),groupid);

    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE t_user SET user_name=?,pass_word=?,nick_name=? WHERE id=?",
               user.getUsername(),user.getPassword(),user.getNickname(),user.getId() );

    }

    @Override
    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM t_user WHERE id=?",id);

    }

    @Override
    public User load(int id) {
        String sql="SELECT   t1.id uid,t1.* ,t2.* FROM t_user t1 LEFT JOIN t_group t2 ON  t1.groupid=t2.id WHERE t1.id=?";
       User users=(User) jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
        return users;
    }

    private class UserMapper implements RowMapper<User>{

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            Group group = new Group();
            group.setId(rs.getInt("id"));
            group.setName(rs.getString("name"));
            User user = new User();
            user.setGroup(group);
            user.setId(rs.getInt("uid"));
            user.setUsername(rs.getString("user_name"));
            user.setPassword(rs.getString("pass_word"));
            user.setNickname(rs.getString("nick_name"));
            return user;
        }
    }
    @Override
    public List<User> list() {
        String sql = "SELECT   t1.id uid,t1.* ,t2.* FROM t_user t1 LEFT JOIN t_group t2 ON  t1.groupid=t2.id";

        return jdbcTemplate.query(sql, (Object[]) null,new UserMapper());
    }
}
