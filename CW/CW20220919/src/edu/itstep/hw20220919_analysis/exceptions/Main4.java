package edu.itstep.hw20220919_analysis.exceptions;

public class Main4 {
    public static void main(String[] args) {
        System.out.println("start");

        String[] arr = {"one", "two", "three", null};
        int index = 3;

        try {
            System.out.println("before");
            System.out.println(arr[index].toUpperCase());
            System.out.println("after");
//        } catch (Exception exception) { // не скомпілюється оскільки даний блок ловитиме цсі помилка, що вказані нижче
//            System.out.println("Exception");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (NullPointerException exception) {
            System.out.println("NullPointerException");
        } catch (Exception exception) {
            System.out.println("Збереження у файл");
            System.out.println(exception.getMessage() + "Збереження у файл");
            System.out.println(exception.toString() + "Збереження у файл");
        } finally {
            System.out.println("finally");
        }
        System.out.println("finish");
    }
}
