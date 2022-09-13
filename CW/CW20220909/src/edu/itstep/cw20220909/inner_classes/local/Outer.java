package edu.itstep.cw20220909.inner_classes.local;

public class Outer {
    private String instanceVariable = "instanceVariable";

    //public void start(){
    public Object start(){
        String localVariable = "localVariable";

        class Inner{ // локальний клас
            private String privateInnerField = "privateInnerField";
            public String publicInnerField = "publicInnerField";

            public void innerMethod(){
                // з методів локального класу можливий доступ до полів та методів ЕВК та до полів та методів ЕЗК,
                // оскільки
                // на момент виклику методу, де оголошено локальний клас, вже обов'язково створено ЕЗК
                System.out.println(privateInnerField);
                System.out.println(publicInnerField);
                System.out.println(instanceVariable); // доступ можливий
                System.out.println(localVariable); // доступ можливий
                instanceVariable = "new value";
                System.out.println(instanceVariable); // доступ можливий
                //localVariable = "new value"; // помилка - локальний клас не може змінювати
                                                // значення локальних змінних !!!
            }
        }

        //Модифікатори доступу полів локального класу можуть бути прописані, але не впливають на поведінку – не застосовуються –
        // маємо випадок жорсткої інкапсуляції, тобто ЕВК можуть створюватись і використовуватись тільки у методі, де були оголошені
        // і більше ніде, тому у приватних полях немає сенсу
        Inner inner = new Inner(); //ОВК створюється лише в межах області видимості, де його оголошено і тільки після блоку оголошення
        System.out.println(inner.privateInnerField); //Модифікатори доступу полів локального класу можуть бути прописані, але не впливають на поведінку – не застосовуються
        System.out.println(inner.publicInnerField); //Модифікатори доступу полів локального класу можуть бути прописані, але не впливають на поведінку – не застосовуються
        System.out.println("-------------------------------------");
        inner.innerMethod();

        return inner; // помилка -  існує можливість повернути ЕВК з методу оголошення,
                        // але у класі має бути вказаний тип поверненого значення - Object (public Object start(){...})
                        // це створює певні складнощі при отриманні даного об'кта у Main -
                        // до функціоналу даного класу доступ отримати неможлитво - доступний тільки функціонал Object
    }
}
