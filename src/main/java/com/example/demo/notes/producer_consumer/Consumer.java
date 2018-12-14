package com.example.demo.notes.producer_consumer;

/**
 * Created by zhangkai on 2018/8/15.
 */
public class Consumer extends Thread {


    private int num;

    private Storage storage;

    public Consumer(Storage storage){
        this.storage =storage;
    }

    public void consume(int num){
        storage.consume(num);
    }

    @Override
    public void run() {
        consume(num);
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
