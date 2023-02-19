package com.geekbrains.Errors_Code;

public class Lorry extends Car,   Moveable, Stopable // необходимо прописать implements
{

    public void move() {
        System.out.println("Car is moving");
    }

    public void stop() {
        System.out.println("Car is stop");
    }
/* так как мы implements от интерфейса  Moveable необходимо переопределить его метод
    @Override
    void open() {

    }




 */

}
