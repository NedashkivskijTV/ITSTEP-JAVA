package edu.itstep.cw20220921repeat2;

import java.util.ArrayList;
import java.util.ListIterator;

public class Main10 {
    public static void main(String[] args) {

        ArrayList<String> states = new ArrayList<String>();
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        states.add("Spain");

        ListIterator<String> listIter = states.listIterator();

        while(listIter.hasNext()){
            System.out.print(listIter.next() + "\t"); // Germany	France	Italy	Spain
        }
        // сейчас текущий элемент - Испания
        // изменим значение этого элемента
        listIter.set("Portugal");

        // пройдемся по элементам в обратном порядке
        System.out.println("\n---------------------------");
        while(listIter.hasPrevious()){
            System.out.print(listIter.previous() + "\t"); // Portugal	Italy	France	Germany
        }

    }
}
