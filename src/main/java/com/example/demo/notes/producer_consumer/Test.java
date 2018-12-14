package com.example.demo.notes.producer_consumer;

/**
 * Created by zhangkai on 2018/8/15.
 */
public class Test {

    public static void main(String[] args) {
        Storage storage = new Storage();
        Consumer consumer1 = new Consumer(storage);
        Consumer consumer2 = new Consumer(storage);
        Consumer consumer3 = new Consumer(storage);

        //
        Producer producer1 = new Producer(storage);
        Producer producer2 = new Producer(storage);
        Producer producer3 = new Producer(storage);

        consumer1.setNum(10);
        consumer2.setNum(20);
        consumer3.setNum(80);

        producer1.setNum(20);
        producer2.setNum(20);
        producer3.setNum(30);




        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();


    }








}
