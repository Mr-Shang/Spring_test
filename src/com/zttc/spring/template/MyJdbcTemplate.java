package com.zttc.spring.template;

import com.zttc.spring.dao.MyCallBack;

/**
 * Created by ¶« on 2016/1/31.
 */
public class MyJdbcTemplate {
    private void beginConnection(){
        System.out.println("begin connection");
    }
    private void closeConnection(){
        System.out.println("close connection");
    }

    public void execute(MyCallBack myCallBack){
        beginConnection();
        myCallBack.doInTemplate();
        closeConnection();

    }
    public void  add( final int id){
        execute(new MyCallBack() {
            @Override
            public void doInTemplate() {
                System.out.println("add"+ id);
            }
        });

    }
    public void delete(int id){
        execute(new MyCallBack() {
            @Override
            public void doInTemplate() {
                System.out.println("delete "+ id);
            }
        });

    }


}
