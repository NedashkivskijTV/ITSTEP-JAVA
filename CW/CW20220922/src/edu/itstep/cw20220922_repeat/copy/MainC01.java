package edu.itstep.cw20220922_repeat.copy;

public class MainC01 {
    public static void main(String[] args) {
        User user = new User("Ivan", "Ivanenko");

        // Створення копій без конструктора копій - Невдале ------------------------------------------------------------
        User copy = user;

        user.setFirstName("Petro");
        System.out.println(copy.getFirstName()); // Petro - без створення конструктора копій
        // посилання на user буде скопійоване до об'єкту copy - інформація не буде незалежною - зміна
        // поля user призведе до зміни відповідного поля copy, оскільки фактично вони посилаються
        // на одну ділянку пам'яті


    }
}
