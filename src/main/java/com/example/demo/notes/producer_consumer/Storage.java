package com.example.demo.notes.producer_consumer;

import java.util.LinkedList;

/**
 * Created by zhangkai on 2018/8/15.
 * 本类用来实现生产者/消费者模式
 * 实际项目中会用到 多个模型转换请求/有限个模型转换服务
 */
public class Storage {

    //最大存储量
    private final int Max_SIZE = 100;

    //存储载体
    private LinkedList<Object> list = new LinkedList<Object>();

    //生产num产品(如果生产量大于仓库最大存储量的时候也会阻塞)
    public void produce(int num){
        //list同步
        synchronized (list){
            //库存不足
            while (list.size()+num>Max_SIZE){
                System.out.println("[库存量]:"+list.size()+"/t[生产数量]:"+num +"/t 不能生产");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //库存充足
            for(int i=0; i<num;i++){
                list.add(new Object());
            }
            System.out.println("[已经生产]:"+num+"/t[现在库存量]:"+list.size());
            list.notifyAll();
        }
    }

    //消费num个产品
    public void consume(int num){

        synchronized (list){
            //库存不足
            while (list.size() < num){
                System.out.println("[库存量]:"+ list.size()+"/t[消费量]:"+num+"/t[库存不足!!!不能消费]");
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //库存充足
            for (int i=0; i<num;i++){
                list.remove();
            }
            System.out.println("[已经消费]:"+num+"/t[剩余库存]:"+list.size());
            list.notifyAll();
        }
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }

    public int getMax_SIZE() {
        return Max_SIZE;
    }
}
