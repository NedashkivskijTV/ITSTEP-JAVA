package edu.itstep.cw20220909.inner_classes.inner;

public class Main {
    public static void main(String[] args) {
        Outer outer = new Outer();//спочатку створюється обєкт зовнішнього класу, конструктор якого
                                    //запускає створення обєкта внутрішнього класу
                                    //це два різних обєкти, що видно по виведених this

        // екземпляр внутрішнього класу можна створити тільки після створення екземпляра
        // зовнішнього класу
        //Inner inner = new Inner(); //створити неможливо - помилка

        Outer.Inner inner1 = outer.new Inner();// обєкт створюється у контексті екземпляра зовнішнього класу
        Outer.Inner inner2 = outer.new Inner();// обєкт створюється у контексті екземпляра зовнішнього класу

        inner1.innerMethod();

        //Outer.Inner inner = new Outer().new Inner();    // при такому створенні відсутнє посилання на зовнішнй клас
                                                        // та викликати його методи неможливо
    }
}
