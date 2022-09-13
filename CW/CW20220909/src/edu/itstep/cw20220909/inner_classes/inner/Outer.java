package edu.itstep.cw20220909.inner_classes.inner;

public class Outer { //зовнішній клас
        //Скорочення
        //ЕЗК - екземпляр зовнішнього класу
        //ЕВК - екземпляр внутрішнього класу
        private String outerPrivateField;
        public String outerPublicField;
        private String test = "OUTERtest";

    public Outer() {

        System.out.println(this);
        System.out.println("Outer");
        Inner inner = new Inner();// створення екземпляра внутрішнього класу
    }
    public void outerMethod(){ // метод зовнішнього класу
        //System.out.println(innerPrivateField); // помилка - зовнішній клас НЕ має доступу до private та public полів внутрішнього
                                                // внутрішній може бути ще не створений
        //System.out.println(innerPublicField); // помилка - зовнішній клас НЕ має доступу до private та public полів внутрішнього

        Inner inner = new Inner(); // Після створення ЕВК - доступ до його полів можливий
        System.out.println(inner.innerPrivateField);
        System.out.println(inner.innerPublicField);
    }

    public class Inner { //внутрішній клас
        private String innerPrivateField;
        public String innerPublicField;
        private String test = "INNERtest";
        public Inner() {
            System.out.println(this);
            System.out.println("Inner");
        }

        public void innerMethod() { // метод внутрішнього класу
            System.out.println(outerPrivateField);  // ЕВК завжди має доступ до полів та методів ЕЗК - на момент створення ЕВК, ЕЗК вже створено (ЕВК існує в контексті ЕЗК)
                                                    // прицьому модифікатор доступу не важливий, оскільки private у поля/метода вказує на те, що його можна викликати тільки з всередині класу,
                                                    // а внутрішній клас існує якраз всередині зовнішнього
            System.out.println(outerPublicField);   // ЕВК завжди має доступ до полів та методів ЕЗК - на момент створення ЕВК, ЕЗК вже створено (ЕВК існує в контексті ЕЗК)
                                                    // прицьому модифікатор доступу не важливий, оскільки private у поля/метода вказує на те, що його можна викликати тільки з всередині класу,
                                                    // а внутрішній клас існує якраз всередині зовнішнього
            System.out.println(test); //INNERtest - затінення (одноіменні змінні у зовнішній та внутрішній області видимості) - звернення до змінної test у внутрішньому класі,
                                                    // оскільки одноіменна змінна у класі зовнішньому це більш глобальна область видимості
            System.out.println(Outer.this.test);    // для звернення до змінної test у зовнішньому класі з внутрішнього використовується наступна конструкція
                                                    // через this - посилання на контекст зовнішнього класу
        }
    }
}
