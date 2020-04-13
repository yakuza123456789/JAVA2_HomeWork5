package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassengerThread extends Thread {
Semaphore semaphore;
CountDownLatch countDownLatch;
private int idPersone;

PassengerThread(Semaphore sem, CountDownLatch countDownLatch, int idPersone ){
    this.countDownLatch = countDownLatch;
    this.semaphore = sem;
    this.idPersone = idPersone;
}

public void run(){

    try {

        System.out.println("Пассажир "+ idPersone +" заходит в кассу");
        sleep(500);
        semaphore.acquire();

        System.out.println("Пассаижр "+ idPersone + " купил билет и выходит из кассы");
        sleep(500);

        System.out.println("Пассажир " + idPersone + " сел в автобус");
        sleep(500);

        System.out.println("Пассажир " + idPersone + " ждет в автобусе");
        sleep(500);
        semaphore.release();
        countDownLatch.countDown();

    } catch (InterruptedException e) {
        e.printStackTrace();
    }

}

}
