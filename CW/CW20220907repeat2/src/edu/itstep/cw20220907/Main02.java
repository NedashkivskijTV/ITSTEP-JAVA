package edu.itstep.cw20220907;

public class Main02 {
    public static void main(String[] args) {
        /**
         * Поліморфізм
         * тестування роботи перегружених методів
         * Навіть при відсутності методу, що строго співпадає по параметрах,
         * буде викликано метод, що в якому компілятор може здійснити приведення
         * типів без втрати точності (int до double) - Так, якщо
         * закоментувати метод test(int i, int j), буде викликано метод test(int i, double j)
         * */
        test(1,2); //


        /**
         * Інший приклад поліморфізму - перевантаження оператору математичної дії "+" (додавання)
         */
        System.out.println("1" + 1);
        System.out.println(1 + 1);
    }


    /** Приклад поліморфізму методів - перевантаження (перегрузка) методів */
    public static void test(int i){
        System.out.println("test - 1");
    }

    public static void test(int i, int j){
        System.out.println("test - 2");
    }

    public static void test(int i, double j){
        System.out.println("test - 3");
    }

}
