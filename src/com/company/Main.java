package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(100);
        Semaphore semaphore = new Semaphore(4, true);
        System.out.println("Автовокзал рейс Бишкек - Ош");

        for (int i = 1; i <= 100; i++) {
            new PassengerThread(semaphore, countDownLatch, i).start();

        }
            try {
                countDownLatch.await();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Автобус с пассажирами выезжает в ОШ ");



    }

}

