package com.zttc.spring.template;

/**
 * Created by �� on 2016/1/31.
 */
public abstract class MyJdbcTemplateIn {
    private void beginConnection(){
        System.out.println("begin connection");
    }
    public abstract void run();
   /*
   在模板类中有一种方法钩子方法，实现类通过钩子方法来控制模板类中的流程。
    */
    public abstract boolean isLog();
    private void closeConnection(){
        System.out.println("close connection");
    }
    public void execute(){
        beginConnection();
        if (isLog()){
            System.out.println("add loginfo");
        }
        run();
        closeConnection();
    }
}
