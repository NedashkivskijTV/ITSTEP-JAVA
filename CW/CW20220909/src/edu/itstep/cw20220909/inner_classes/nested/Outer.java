package edu.itstep.cw20220909.inner_classes.nested;

public class Outer { //зовнішній клас
        //Скорочення
        //ЕЗК - екземпляр зовнішнього класу
        //ЕВК - екземпляр внутрішнього класу
        private String outerPrivateField;
        public String outerPublicField;
        public static int outerPrivateStaticField = 777;

    public Outer() {
        System.out.println(this);
        System.out.println("Outer");
    }
    public void outerMethod(){ // метод зовнішнього класу
//        System.out.println(nestedPrivateField);//помилка - звернутись неможливо, оскільки на етапі воклику методу outerMethod() жодного ЕВК може не існувати
//        System.out.println(nestedPublicField);//помилка - звернутись неможливо, оскільки на етапі воклику методу outerMethod() жодного ЕВК може не існувати

        // доступ до полів вложеного класу можливий лише після створення ЕВК
        Nested nested = new Nested();
        System.out.println(nested.nestedPrivateField);
        System.out.println(nested.nestedPublicField);
    }

    public static class Nested { //внутрішній клас
        private String nestedPrivateField = "pr";
        public String nestedPublicField = "pab";
        public Nested() {
            System.out.println(this);
            System.out.println("Inner");
        }

        public void innerNested() { // метод внутрішнього класу
            // основна відмінність внутрішніх та вложених(статичних) класів у тому, що
            // вложені, на відміну від внутрішніх, не мають доступу до змінних ЕЗК
            // - оскільки ЕВК може існувати без створення ЕВК
            // можливий лише доступ з ЕВК до статичних полів та методів ЕЗК
//            System.out.println(outerPrivateField); //помилка - викликати поля ЕЗК неможливо, оскільки на момент роботи метода ЕЗК може не існувати, а також через те, що внутрішній метод - статичний, а статичні методи працюють лише зі статичними змінними, а змінні ЕЗК такими не являються
//            System.out.println(outerPublicField); //помилка - викликати поля ЕЗК неможливо, оскільки на момент роботи метода ЕЗК може не існувати, а також через те, що внутрішній метод - статичний, а статичні методи працюють лише зі статичними змінними, а змінні ЕЗК такими не являються
            System.out.println(outerPrivateStaticField); // доступ можливий
        }
    }
}
