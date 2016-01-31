package com.zttc.spring.dao;

import com.zttc.spring.model.Group;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by meidejiule on 2016/1/30......
 */
@Repository("groupJdbcDao")
public class GroupDao implements IGroupDao {
    private JdbcTemplate jdbcTemplate;

    @Resource
    public void setDataSource(BasicDataSource basicDataSource){
        jdbcTemplate=new JdbcTemplate(basicDataSource);
    }

    @Override
    public void add( final Group group) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                new PreparedStatementCreator() {
                    /*
                    通过以下方法添加对象，并且获取自动递增的id；
                     */
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        String sql="insert into t_group (name) value (?)";
                        PreparedStatement preparedStatement=con.prepareStatement(sql,new String[] {"id"});
                        preparedStatement.setString(1,group.getName());
                       // preparedStatement.setString(1,group.getName());
                        return preparedStatement;
                    }
                },keyHolder);
        group.setId(keyHolder.getKey().intValue());
        System.out.println(keyHolder.getKey());
    }
}
