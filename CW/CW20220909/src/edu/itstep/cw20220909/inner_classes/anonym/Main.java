package edu.itstep.cw20220909.inner_classes.anonym;

public class Main {
    public static void main(String[] args) {
        Parent parent = new Child();

        //parent - зберігає посилання на обєкт класу Child
        System.out.println(parent);
        parent.showName();
        ((Child)parent).personalChild(); // спосіб дотягнутись до
        // функціоналу дочірнього класу (при збереженні у змінній батьківського класу)
        // через приведення до типу дочірнього класу

        System.out.println("-----------------------------------");

        // створення анонімного класу
        // Анонімний клас завжди є наслідником класу, у якому створений
        Parent anonym = new Parent(){
            @Override
            public void showName() { //у анонімному класі можна перевизначити методи батьківського
                //super.showName();
                System.out.println("anonymous");
            }
        };
        anonym.showName();

    }
}
