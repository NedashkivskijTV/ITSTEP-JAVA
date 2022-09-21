package edu.itstep.cw20220914_analysis.references;

public class CalcUtil {
    // метод, що за сигнатурами збігається з оголошеним у інтерфейсі Calculator
    // методом execute
    // статичний метод потребує виклику через назву класу
    // стан недоступний
    public static double multiplication(int value1, int value2){
        return 1.0 * value1 * value2;
    }

    // нестатичний метод потребує виклику через екземпляр класу
    // може використовувати стан
    public double multiplicationNonStatic(int value1, int value2){
        return 1.0 * value1 * value2;
    }
}
