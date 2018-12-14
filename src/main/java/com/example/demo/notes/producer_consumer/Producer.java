package com.example.demo.notes.producer_consumer;

/**
 * Created by zhangkai on 2018/8/15.
 *生产者类
 */
public class Producer extends Thread {

    //生产数量
    private int num;
    //放置的仓库
    private Storage storage;

    public Producer(Storage storage){
        this.storage = storage;
    }


    @Override
    public void run() {
        produce(num);
    }

    public void produce(int num){
        storage.produce(num);
    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
