package com.geekbrains.Thread;

public class PinPong {
    public static void main(String[] args) {
        Object LOCK_OBJECT = new Object();
        Thread ping = new Thread(new PinPongThread(LOCK_OBJECT, "Ping"));
        Thread pong = new Thread(new PinPongThread(LOCK_OBJECT, "Pong"));
        ping.start();
        pong.start();
    }
}
