package edu.itstep.cw20220929_repeat.lambda;

import java.util.function.Predicate;

public class Controller {

    private String instanceVariable = "old instance"; // змінна екземпляра

    public void start(){

        // Використання локальних змінних в тілі лямбда-функції та анонімного класу

        String localVariable = "old local"; // локальна змінна - НЕ ЗМІНЮЄТЬСЯ в тілі лямбди або анонімного класу !!!
        final String[] localVariableMass = {"old localMass"};

        Predicate<Integer> predicate1 = (v) -> {
            // отримання локальної змінної та змінної екземпляра в тілі лямбди
            // 1 - використання змінної екземпляра - дозволяється читання та зміна
            System.out.println(instanceVariable); // old instance - можливе і отримання значення і його зміна в ході виконання
            instanceVariable = "new instance";
            System.out.println(instanceVariable); // new instance - можливе і отримання значення і його зміна в ході виконання

            // локальна зміннна - дозволяється тільки читання !!! - проблема у стеку - змінна створюється у стеку і як тільки стек закінчується змінна знищується
            System.out.println(localVariable); // old local - підкреслена змінна - константне значення - НЕ ЗАСТОСОВУЄТЬСЯ якщо потрібна зміна значення данної змінної під час виконання коду
            //localVariable = "new local"; // помилка

            // 2 - використання массиву - дозволяється читання та зміна
            System.out.println(localVariableMass[0]); // old localMass
            localVariableMass[0] = "new localMass";
            System.out.println(localVariableMass[0]); // new localMass

            // 3 - створення копії локальної змінної - дозволяється читання та зміна
            String copy = localVariable;
            System.out.println(copy); // old local
            copy = "new local";
            System.out.println(copy);// new local

            return v < 0;
        }; // лямбда-функція


        Predicate<Integer> predicate2 = new Predicate<Integer>() { // анонімний клас
            @Override
            public boolean test(Integer integer) {
                // отримання локальної змінної та змінної класу в тілі анонімного класу
                //1 - використання змінної екземпляра - дозволяється читання та зміна
                System.out.println(instanceVariable); // new instance - можливе і отримання значення і його зміна в ході виконання
                instanceVariable = "new instanceAnonymous";
                System.out.println(instanceVariable); // new instanceAnonymous - можливе і отримання значення і його зміна в ході виконання

                // локальна зміннна - дозволяється тільки читання !!! - проблема у стеку - змінна створюється у стеку і як тільки стек закінчується змінна знищується
                System.out.println(localVariable); // old local - підкреслена змінна - константне значення - НЕ ЗАСТОСОВУЄТЬСЯ якщо потрібна зміна значення данної змінної під час виконання коду
                //localVariable = "new local"; // помилка

                //2 - використання массиву - дозволяється читання та зміна
                System.out.println(localVariableMass[0]); // new local
                localVariableMass[0] = "new localMassAnonymous";
                System.out.println(localVariableMass[0]); // new localMassAnonymous

                // 3 - створення копії локальної змінної - дозволяється читання та зміна
                String copy = localVariable;
                System.out.println(copy); // old local
                copy = "new local";
                System.out.println(copy);// new local

                return integer > 0;
            }
        };
        // тестування вищевикладеного коду
        predicate1.test(7);
        System.out.println("-----------------------------------------------------------------------------------------");
        predicate2.test(7);
    }
}
