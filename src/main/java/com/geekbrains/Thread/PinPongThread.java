package com.geekbrains.Thread;


/*
1) wait() и notify()являются методом объекта, поэтому вам нужно создать LOCK_OBJECT для вызова этих методов.
Вы передаете этот LOCK_OBJECT из конструктора. Оба потока пытаются получить блокировку для LOCK_OBJECT,
когда один поток блокирует этот объект, другой поток не может получить доступ к ресурсам.
2) wait() и notify()методы могут вызываться только внутри синхронизированного блока.
3) wait() и notify()методы вызываются внутри while(true)цикла для продолжения выполнения потока.
4)ait() и sleep()метод генерирует InterruptedExceptionисключение.
5) sleep()Метод является необязательным. Он используется для добавления задержки в 1 секунду
при печати “Ping” и “Pong”, чтобы проверить последовательность в консоли.
 */
public class PinPongThread implements Runnable{


    private Object LOCK_OBJECT;
    private String name;

    public PinPongThread(Object LOCK_OBJECT, String name) {
        this.LOCK_OBJECT = LOCK_OBJECT;
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (LOCK_OBJECT) {
            while(true) {
                System.out.println(name);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                LOCK_OBJECT.notify();

                try {
                    LOCK_OBJECT.wait(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
